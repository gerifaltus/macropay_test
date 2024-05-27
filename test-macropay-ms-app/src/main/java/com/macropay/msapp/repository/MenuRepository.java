package com.macropay.msapp.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.macropay.msapp.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{
    
    @Query("SELECT m FROM Menu m WHERE m.typeMenu = :menuType")
    Set<Menu> getMenuGeneral(@Param("menuType") String menuType);

}
