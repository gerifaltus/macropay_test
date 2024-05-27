package com.macropay.msapp.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macropay.msapp.dto.PrestamoGeneralDto;
import com.macropay.msapp.dto.PrestamoRequestDto;
import com.macropay.msapp.service.PrestamosService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RequestMapping("/api/v1")
@RestController
public class PrestamosController {

    private PrestamosService prestamosService;

    public PrestamosController(PrestamosService prestamosService) {
        super();
        this.prestamosService = prestamosService;
    }
    
    @PostMapping("/prestamos")
    public PrestamoGeneralDto getPrestamos(@RequestBody PrestamoRequestDto prestamoRequestDto) {
        return this.prestamosService.getPrestamos(
                prestamoRequestDto.getFechaActual(), 
                prestamoRequestDto.getTasaInteres(), 
                prestamoRequestDto.getDiasAnioComercial());
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/prestamos/{client}")
    public void guardarPago(@RequestBody PrestamoRequestDto prestamoRequestDto, 
            @PathVariable @Valid @NotBlank String client) {
        this.prestamosService.pagoPrestamo(prestamoRequestDto, client);
    }
}
