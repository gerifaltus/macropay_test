package com.macropay.msapp.service.impl;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macropay.msapp.dto.MenuDto;
import com.macropay.msapp.entity.Menu;
import com.macropay.msapp.repository.MenuRepository;
import com.macropay.msapp.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService{

    private static final String TYPE_MENU_GROUP = "group";
    private static final String TYPE_MENU_COLLAPSABLE = "collapsable";
    private static final String TYPE_MENU_BASIC = "basic";
    
    private ObjectMapper mapper = new ObjectMapper();
    
    private MenuRepository menuRepository;
    
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /**
     * Método para extraer el Menu desde la bd y generar el arbol en la clase MenuDto
     */
    @Override
    public List<MenuDto> getMenu() {
        Set<Menu> listMenu = this.menuRepository.getMenuGeneral(TYPE_MENU_GROUP);
        List<MenuDto> listMenuDto = new ArrayList<>();
        
        for(Menu menu : listMenu) {
            MenuDto menuDto = this.fromMenuToMenuDto(menu);
            listMenuDto.add(menuDto);
            processChildrenMenu(menu.getChildren(), menuDto);
        }
        
        return listMenuDto;
    }

    /**
     * Método para guardar el menu desde el archivo json
     */
    @Override
    public Menu loadMenu() {
        Menu menu = this.getJson();
        
        if(!Objects.isNull(menu)) {
            this.saveMenu(menu);
            return menu;
        }
        
        return null;
    }
    
    /**
     * Método para procesar recursivamente el menú
     * @param listMenu
     * @param parent
     */
    private void processChildrenMenu(Set<Menu> listMenu, MenuDto parent) {
        if(listMenu == null) {
            return;
        }
        
        for(Menu menu : listMenu) {
            MenuDto menuNvoDto = this.fromMenuToMenuDto(menu);
            parent.getChildren().add(menuNvoDto);
            this.processChildrenMenu(menu.getChildren(), menuNvoDto);
        }
    }
    
    /**
     * Método para mapear la clase MenuDto con el contenido de la clase Menu
     * @param menuJson
     * @return MenuDto
     */
    private MenuDto fromMenuToMenuDto(Menu menuJson) {
        MenuDto menuDto = new MenuDto();
        if(menuJson.getChildren() != null) {
            menuDto.setChildren(new HashSet<>(1));
        }
        menuDto.setIcon(menuJson.getIcon());
        menuDto.setLink(menuJson.getLink());
        menuDto.setTitle(menuJson.getTitle());
        menuDto.setType(menuJson.getTypeMenu());
        if(menuJson.getTypeMenu().equalsIgnoreCase(TYPE_MENU_BASIC)) {
            menuDto.setId(menuJson.getId());
        }
        return menuDto;
    }
    
    /**
     * Método recursivo para guardar el menu
     * @param menu
     */
    private void saveMenu(Menu menu) {
        menuRepository.save(menu);
        if(menu.getChildren() != null) {
            this.saveMenu(menu.getChildren());
        }
    }
    
    /**
     * Método recursivo para guardar los children de cada emnu
     * @param listMenu
     */
    private void saveMenu(Set<Menu> listMenu) {
        for(Menu menu : listMenu) {
            this.saveMenu(menu);
        }
    }
    
    /**
     * Método para cargar el archivo menu.json y mapearlo a la clase Menu
     * @return Menu
     */
    private Menu getJson() {
        try (InputStream isJson = getClass().getClassLoader().getResourceAsStream("menu.json");){
            return mapper.readerFor(Menu.class).readValue(isJson);
        } catch (Exception e) {
            log.error("Error al cargar el archivo menu.json", e);
            return null;
        }
    }
}
