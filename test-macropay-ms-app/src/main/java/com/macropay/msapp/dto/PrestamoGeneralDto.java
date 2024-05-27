package com.macropay.msapp.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoGeneralDto implements Serializable{/**
     * 
     */
    private static final long serialVersionUID = -9132348877885974867L;
    
    private List<PrestamoListDto> pagos;
    private List<PrestamoDto> cuentas;
}
