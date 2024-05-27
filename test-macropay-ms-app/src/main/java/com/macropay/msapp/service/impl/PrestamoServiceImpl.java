package com.macropay.msapp.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.macropay.msapp.dto.PrestamoGeneralDto;
import com.macropay.msapp.dto.PrestamoRequestDto;
import com.macropay.msapp.repository.PrestamosRepositoryCustom;
import com.macropay.msapp.service.PrestamosService;

@Service
public class PrestamoServiceImpl implements PrestamosService{

    private PrestamosRepositoryCustom prestamosRepositoryCustom;
    
    public PrestamoServiceImpl(PrestamosRepositoryCustom prestamosRepositoryCustom) {
        super();
        this.prestamosRepositoryCustom = prestamosRepositoryCustom;
    }

    @Override
    public PrestamoGeneralDto getPrestamos(String fechaActual, BigDecimal interes, Integer diasAnio) {
        return this.prestamosRepositoryCustom.getPagos(fechaActual, interes, diasAnio);
    }

    @Override
    public void pagoPrestamo(PrestamoRequestDto prestamoRequestDto, String client) {
        this.prestamosRepositoryCustom.pagoPrestamo(
                client,
                prestamoRequestDto.getFechaActual(),
                prestamoRequestDto.getTasaInteres(),
                prestamoRequestDto.getDiasAnioComercial(),
                prestamoRequestDto.getPago()
                );
    }

}
