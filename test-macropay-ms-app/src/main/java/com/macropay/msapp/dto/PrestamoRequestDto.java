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
public class PrestamoRequestDto implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -1667997396066888035L;
    private String fechaActual;
    private BigDecimal tasaInteres;
    private Integer diasAnioComercial;
    private BigDecimal pago;
}
