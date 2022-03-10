package com.altia.cvprocessingbackend.service;


import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.*;



public interface ReportService {

    public String exportReport (String email, String platform) throws FileNotFoundException, JRException;
}
