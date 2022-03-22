package com.altia.cvprocessingbackend.service.impl;

import com.altia.cvprocessingbackend.persistence.repository.CandidatoRepository;
import com.altia.cvprocessingbackend.runner.Runner;
import com.altia.cvprocessingbackend.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La Clase ReportServiceImpl
 */
@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private CandidatoRepository candidatoRepository;

    /**
     * Exportar reporte
     * @param email
     * @param platform
     * @return Fichero CV
     * @throws FileNotFoundException
     * @throws JRException
     */
    public Mono<Resource> exportReport(String email, String platform)
            throws FileNotFoundException, JRException {

        logger.info("Email is : " + email);
        logger.info("Platform is : " + platform);
        return candidatoRepository.findByEmail(email, platform).map(candidato -> {
        Resource result = null;
        try {
            File template = ResourceUtils.getFile("classpath:jasper/candidates.jrxml");
            System.out.println("file.getAbsolutePath(): " + template.getAbsolutePath());
            JasperReport jasperReport = JasperCompileManager.compileReport(template.getAbsolutePath());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
                    Arrays.asList(candidato));
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Hunters");
            JasperPrint jasperPrint = JasperFillManager
                    .fillReport(jasperReport, parameters, dataSource);

            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            File exportReportFile = new File("test.docx");
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
            exporter.exportReport();
            result = new ByteArrayResource(Files.readAllBytes(exportReportFile.toPath()));
            exportReportFile.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

        ).subscribeOn(Schedulers.boundedElastic());

    }

}

