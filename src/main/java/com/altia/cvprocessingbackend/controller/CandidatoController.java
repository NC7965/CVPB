package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.service.CandidatoService;
import com.altia.cvprocessingbackend.service.ReportService;

import java.io.*;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * La clase CandidatoController
 */
@RestController
@RequestMapping("/candidatos")
@Slf4j
@CrossOrigin("*")
public class CandidatoController {

    public int STATUS_CODE_OK = 200;
    /**
     * El servicio de Candidato
     */
    @Autowired
    private CandidatoService candidatoService;

    /**
     * Rol
     */
    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }

    /**
     * El servicio de Reportes
     */
    @Autowired
    private ReportService reportService;

    /**
     * Busca por id un candidato y lo devuelve
     * @param id
     * @return El CandidatoVO(Mono)
     */
    @GetMapping("/{id}")
    public Mono<CandidatoVO> getCandidato(@PathVariable("id") String id) {
        return candidatoService.findById(id);
    }
    /**
     *
     * @param token de dédalo
     * @return status devuelve el código de respuesta para la petición de guardado en Dédalo.
     */
    public int generarPeticionDedalo(String token){
        int status = 0;
        try {
            StringBuilder resultado = new StringBuilder();
            URL url = new URL("https://dedalo.altia.es/dedalo/my/account.json");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("X-Redmine-API-Key", token);
            conexion.setInstanceFollowRedirects(false);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            rd.close();
            status = conexion.getResponseCode();
            log.info("Info: "+resultado.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * Crea un CV y lo almacena
     * @param candidatoVO
     * @return "OK" o Error:404 en función de si el token es valido o no en Dédalo.
     */
    @PostMapping("/dedalo")
    public String SaveDedalo(@RequestBody CandidatoVO candidatoVO, @RequestHeader ("X-Redmine-API-Key") String token) throws JRException, FileNotFoundException {
        log.info("request body recibido en hebra {}",Thread.currentThread().getName());
        int status = generarPeticionDedalo(token);
        if(status==STATUS_CODE_OK){
            candidatoService.saveCandidato(candidatoVO);
            Mono<Resource> report = reportService.exportReport(candidatoVO.getEmail(),candidatoVO.getSitioWeb());
            return "OK";
        }
        else{
            log.info("No tienes permisos!");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Token not found."
            );
        }
    }



    /**
     * Crea un CV y lo almacena
     * @param candidatoVO
     * @return Almacena el candidato en la base de datos.
     */
    @PostMapping("/")
    public String  crearCV(@RequestBody CandidatoVO candidatoVO) {
        log.info("request body recibido en hebra {}",Thread.currentThread().getName());
        candidatoService.saveCandidato(candidatoVO);
        return "Almacenado correcto";
    }

    /**
     * Busca y devuelve todos los candidatos
     * @return El/los CandidatoVO(Flux)
     */
    @GetMapping("")
    public Flux<CandidatoVO> findAll(){
        return candidatoService.findAll();
    }
    /**
     *
     * @param email
     * @param platform
     * @param response
     * @return fichero CV
     * @throws JRException
     * @throws FileNotFoundException
     * @throws JRException
     */
    @GetMapping(value = "/report" ,  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public Mono<Resource> exportReport (@RequestParam String email, @RequestParam String platform, ServerHttpResponse response) throws JRException, FileNotFoundException, JRException {

        response.getHeaders().add("Content-Disposition",String.format("attachment; filename=%s.pdf",email));
        log.info("request report recibido en hebra {}",Thread.currentThread().getName());
        return reportService.exportReport( email,platform);
    }


}
