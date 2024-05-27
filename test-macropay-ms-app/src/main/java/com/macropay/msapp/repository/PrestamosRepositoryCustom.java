package com.macropay.msapp.repository;

import java.math.BigDecimal;

import com.macropay.msapp.dto.PrestamoGeneralDto;

public interface PrestamosRepositoryCustom {

    PrestamoGeneralDto getPagos(String fechaActual, BigDecimal interes, Integer diasAnio);
    
    void pagoPrestamo(String client, String fechaActual, BigDecimal interes, Integer diasAnio, BigDecimal bigDecimal);
}
