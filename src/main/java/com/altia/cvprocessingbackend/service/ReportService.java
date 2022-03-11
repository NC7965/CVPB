package com.altia.cvprocessingbackend.service;


import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.*;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;


public interface ReportService {

    public Mono<Resource> exportReport (String email, String platform) throws FileNotFoundException, JRException;
}
