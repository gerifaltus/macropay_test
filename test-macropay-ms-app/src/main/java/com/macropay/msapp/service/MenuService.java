package com.macropay.msapp.service;

import java.util.List;

import com.macropay.msapp.dto.MenuDto;
import com.macropay.msapp.entity.Menu;

public interface MenuService {
    
    List<MenuDto> getMenu();
   
    Menu loadMenu();
}
