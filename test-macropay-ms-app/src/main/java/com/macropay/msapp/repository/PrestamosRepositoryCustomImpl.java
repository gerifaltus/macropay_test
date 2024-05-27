package com.macropay.msapp.repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.macropay.msapp.dto.PrestamoDto;
import com.macropay.msapp.dto.PrestamoGeneralDto;
import com.macropay.msapp.dto.PrestamoListDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrestamosRepositoryCustomImpl implements PrestamosRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public PrestamoGeneralDto getPagos(String fechaActual, BigDecimal interes, Integer diasAnio) {
        PrestamoGeneralDto dto = new PrestamoGeneralDto();
        StoredProcedureQuery spPrestamos =
                em.createStoredProcedureQuery("GET_ADEUDOS_CUENTAS");
        
        spPrestamos.registerStoredProcedureParameter(
                "in_fecha_actual", String.class, ParameterMode.IN)
            .setParameter("in_fecha_actual", fechaActual);
        spPrestamos.registerStoredProcedureParameter(
                "in_tasa_interes", BigDecimal.class, ParameterMode.IN)
            .setParameter("in_tasa_interes", interes);
        spPrestamos.registerStoredProcedureParameter(
                "in_dias_anio_comercial", Integer.class, ParameterMode.IN)
            .setParameter("in_dias_anio_comercial", diasAnio);
        
        spPrestamos.execute();
        
        
        List<Object[]> resultsPagos = spPrestamos.getResultList();
        List<PrestamoListDto> listPagos = resultsPagos
                .stream()
                .map(result -> new PrestamoListDto(
                (String) result[0],
                (Integer) result[1],
                (BigDecimal) result[2],
                (BigDecimal) result[3],
                (BigDecimal) result[4],
                (BigDecimal) result[5]
            )).toList();
        
        dto.setPagos(listPagos);
        dto.setCuentas(Collections.emptyList());
        
        if(spPrestamos.hasMoreResults()) {
            List<Object[]> resutlCuentas = spPrestamos.getResultList();
            List<PrestamoDto> listCuentas = resutlCuentas
                    .stream()
                    .map(result -> new PrestamoDto(
                    (String) result[0],
                    (BigDecimal) result[1]
                )).toList();
            
            dto.setCuentas(listCuentas);
        }
        
        return dto;
    }

    @Transactional
    @Override
    public void pagoPrestamo(String client, String fechaActual, 
            BigDecimal interes, Integer diasAnio, BigDecimal pago) {
        
        try {
            
        StoredProcedureQuery spPrestamos =
                em.createStoredProcedureQuery("UPDATE_PAGOS");
        
        spPrestamos.registerStoredProcedureParameter(
                "in_client", String.class, ParameterMode.IN)
            .setParameter("in_client", client);
        spPrestamos.registerStoredProcedureParameter(
                "in_fecha_actual", String.class, ParameterMode.IN)
            .setParameter("in_fecha_actual", fechaActual);
        spPrestamos.registerStoredProcedureParameter(
                "in_tasa_interes", BigDecimal.class, ParameterMode.IN)
            .setParameter("in_tasa_interes", interes);
        spPrestamos.registerStoredProcedureParameter(
                "in_dias_anio_comercial", Integer.class, ParameterMode.IN)
            .setParameter("in_dias_anio_comercial", diasAnio);
        spPrestamos.registerStoredProcedureParameter(
                "in_pago", BigDecimal.class, ParameterMode.IN)
            .setParameter("in_pago", pago);
        
            int result = spPrestamos.executeUpdate();
            log.info("Respuesta desde el update: "+result);
        } catch (Exception e) {
            log.error("Error al aplicar el pago: ", e);
        }
        
    }

}
