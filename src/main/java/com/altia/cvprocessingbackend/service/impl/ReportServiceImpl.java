package com.altia.cvprocessingbackend.service.impl;

import com.altia.cvprocessingbackend.persistence.repository.CandidatoRepository;
import com.altia.cvprocessingbackend.runner.Runner;
import com.altia.cvprocessingbackend.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private CandidatoRepository candidatoRepository;


    public String exportReport (String email, String platform) throws FileNotFoundException, JRException {

        logger.info("Email is : "+ email);
        logger.info("Platform is : "+ platform);
        candidatoRepository.findByEmail( email, platform).map(candidato -> {
                    try {
                        File file = ResourceUtils.getFile("classpath:jasper/candidates.jrxml");
                        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
                        System.out.println("file.getAbsolutePath(): "+ file.getAbsolutePath());

                        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Arrays.asList(candidato));
                        Map<String,Object> parameters= new HashMap<>();
                        parameters.put("createdBy", "Hunters");
                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
                        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\tahir.farooq\\Desktop\\Spring-boot-reactive-webflux\\candidato.pdf");

                        // JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\tahir.farooq\\Desktop\\Spring-boot-reactive-webflux\\candidato.pdf");

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }

                    return "Report generated";
                }

        ).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();

        return "Report generated!!!";
    }

}

