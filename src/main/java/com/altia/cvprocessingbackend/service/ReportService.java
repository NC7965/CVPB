package com.altia.cvprocessingbackend.service;


import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.*;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

/**
 * La Interfaz ReportService
 */
public interface ReportService {

    /**
     * Exportar reporte
     * @param email
     * @param platform
     * @return Fichero CV
     * @throws FileNotFoundException
     * @throws JRException
     */
    public Mono<Resource> exportReport (String email, String platform) throws FileNotFoundException, JRException;
}
