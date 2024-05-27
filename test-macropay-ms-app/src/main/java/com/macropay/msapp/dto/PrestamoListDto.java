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
public class PrestamoListDto implements Serializable{/**
     * 
     */
    private static final long serialVersionUID = 1253524853602957041L;
    
    private String cliente;
    private Integer plazo;
    private BigDecimal monto;
    private BigDecimal interes;
    private BigDecimal iva;
    private BigDecimal pago;
}
