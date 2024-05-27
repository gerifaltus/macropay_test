package com.macropay.msapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDto implements Serializable{/**
     * 
     */
    private static final long serialVersionUID = 7628162818012220094L;
    private String cliente;
    private BigDecimal monto;

}
