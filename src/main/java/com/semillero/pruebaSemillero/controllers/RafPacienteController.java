package com.semillero.pruebaSemillero.controllers;

import com.semillero.pruebaSemillero.dao.RafPacienteDAO;
import com.semillero.pruebaSemillero.dao.RafEspecieDAO;
import com.semillero.pruebaSemillero.dao.RafRazaDAO;
import com.semillero.pruebaSemillero.dao.RafTipoDocumentoDAO;
import com.semillero.pruebaSemillero.models.RafEspecieModel;
import com.semillero.pruebaSemillero.models.RafPacientesModel;
import com.semillero.pruebaSemillero.models.RafRazaModel;
import com.semillero.pruebaSemillero.models.RafTipoDocumentoModel;
import com.semillero.pruebaSemillero.utils.JWTUtil;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RafPacienteController {

    @Autowired
    private RafPacienteDAO rafPacienteDAO;

    @Autowired
    private RafEspecieDAO rafEspecieDAO;
    @Autowired
    private RafRazaDAO rafRazaDAO;

    @Autowired
    private RafTipoDocumentoDAO rafTipoDocumentoDAO;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/getPacientes", method = RequestMethod.GET)
    public List<RafPacientesModel> getPacientes(@RequestHeader(value = "Authorization") String token){

        //if(!validarToken(token)){return null;}

        return rafPacienteDAO.getPacientes();
    }

    private boolean validarToken(String token) {

        String administradorId = jwtUtil.getKey(token);//se extrae el id del usuario
        return administradorId != null;

    }

    @RequestMapping(value = "api/pacientes/{id}", method = RequestMethod.DELETE)
    public void eliminarPacientes(@PathVariable Long id){

        //if(!validarToken(token)){return;}
        rafPacienteDAO.eliminarPacientes(id);
    }

    @RequestMapping(value = "api/pacientes/update/{id}", method = RequestMethod.PUT)
    public void actualizarPacientes(@PathVariable Long id,
                                    @RequestBody RafPacientesModel rafPacientesModel){
        rafPacienteDAO.actualizarPacientes(id, rafPacientesModel);
    }



    @RequestMapping(value = "api/pacientes/crear", method = RequestMethod.POST)
    public void registrarPacientes(@RequestBody RafPacientesModel rafPacientesModel){
        rafPacienteDAO.registrarPaciente(rafPacientesModel);
    }

    @RequestMapping(value = "api/getEspecies", method = RequestMethod.GET)
    public List<RafEspecieModel> getEspecies(@RequestHeader(value = "Authorization") String token){

        return rafEspecieDAO.getEspecies();
    }

    @RequestMapping(value = "api/getRazas", method = RequestMethod.GET)
    public List<RafRazaModel> getRazas(){

        return rafRazaDAO.getRazas();
    }

    @RequestMapping(value = "api/getTiposDocumentos", method = RequestMethod.GET)
    public List<RafTipoDocumentoModel> getTiposDocumentos(){

        return rafTipoDocumentoDAO.getTiposDocumentos();
    }


    @RequestMapping(value = "api/getPacienteId/{id}", method = RequestMethod.GET)
    public Optional<RafPacientesModel> getPacienteId(@PathVariable Long id) {

        return rafPacienteDAO.getPacientesId(id);
    }

    @RequestMapping(value = "api/exportPacientes", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> exportPacientes()throws Exception{
        ByteArrayInputStream stream = rafPacienteDAO.exportPacientes();

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition","attachment; filename= pacientes.xls" );

        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));

    }

}
