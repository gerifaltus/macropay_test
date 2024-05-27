package com.macropay.msapp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macropay.msapp.dto.MenuDto;
import com.macropay.msapp.entity.Menu;
import com.macropay.msapp.service.MenuService;

@RequestMapping("/api/v1")
@RestController
public class MenuController {

    private MenuService menuService;
    
    public MenuController(MenuService menuService) {
        super();
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public List<MenuDto> getMenu() {
        return menuService.getMenu();
    }
    
    @GetMapping("/menu/load")
    public ResponseEntity<String> loadMenu() {
        Menu menu = menuService.loadMenu();
        
        if(!Objects.isNull(menu)) {
            return new ResponseEntity<>("Menu cargado correctamente desde el archivo menu.json", HttpStatus.OK);
        }
        
        return new ResponseEntity<>("Hubo un problema al cargar el archivo menu.json, consulte a soporte", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
