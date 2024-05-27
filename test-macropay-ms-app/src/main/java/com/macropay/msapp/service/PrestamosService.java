package com.macropay.msapp.service;

import java.math.BigDecimal;

import com.macropay.msapp.dto.PrestamoGeneralDto;
import com.macropay.msapp.dto.PrestamoRequestDto;

public interface PrestamosService {

    PrestamoGeneralDto getPrestamos(String fechaActual, BigDecimal interes, Integer diasAnio);

    void pagoPrestamo(PrestamoRequestDto prestamoRequestDto, String client);
}
