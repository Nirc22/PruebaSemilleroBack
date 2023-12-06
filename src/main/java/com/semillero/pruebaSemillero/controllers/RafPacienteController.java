package com.semillero.pruebaSemillero.controllers;

import com.semillero.pruebaSemillero.dao.RafPacienteDAO;
import com.semillero.pruebaSemillero.dao.RafEspecieDAO;
import com.semillero.pruebaSemillero.models.RafEspecieModel;
import com.semillero.pruebaSemillero.models.RafPacientesModel;
import com.semillero.pruebaSemillero.utils.JWTUtil;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RafPacienteController {

    @Autowired
    private RafPacienteDAO rafPacienteDAO;

    @Autowired
    private RafEspecieDAO rafEspecieDAO;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/pacientes", method = RequestMethod.GET)
    public List<RafPacientesModel> getPacientes(@RequestHeader(value = "Authorization") String token){

        //if(!validarToken(token)){return null;}

        return rafPacienteDAO.getPacientes();
    }

    private boolean validarToken(String token) {

        String administradorId = jwtUtil.getKey(token);//se extrae el id del usuario
        return administradorId != null;

    }

    @RequestMapping(value = "api/pacientes/{id}", method = RequestMethod.DELETE)
    public void eliminarPacientes(@RequestHeader (value = "Authorization") String token,
                                  @PathVariable Long id){

        //if(!validarToken(token)){return;}
        rafPacienteDAO.eliminarPacientes(id);//tratar con String
    }

    @RequestMapping(value = "api/pacientes/crear", method = RequestMethod.POST)
    public void registrarPacientes(@RequestBody RafPacientesModel rafPacientesModel){
        rafPacienteDAO.registrarPaciente(rafPacientesModel);
    }

    @RequestMapping(value = "api/especies", method = RequestMethod.GET)
    public List<RafEspecieModel> getEspecies(@RequestHeader(value = "Authorization") String token){

        return rafEspecieDAO.getEspecies();
    }

}
