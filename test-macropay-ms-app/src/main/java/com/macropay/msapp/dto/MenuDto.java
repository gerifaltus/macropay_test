package com.macropay.msapp.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuDto implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 2963514760260663610L;
    
    private Integer id;
    private String title;
    private String type;
    private String icon;
    private String link;
    private Set<MenuDto> children;
}
