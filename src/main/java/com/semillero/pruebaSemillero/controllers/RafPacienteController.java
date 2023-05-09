package com.semillero.pruebaSemillero.controllers;

import com.semillero.pruebaSemillero.dao.RafPacienteDAO;
import com.semillero.pruebaSemillero.models.RafPacientesModel;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RafPacienteController {

    @Autowired
    private RafPacienteDAO rafPacienteDAO;

    @RequestMapping(value = "api/pacientes", method = RequestMethod.GET)
    public List<RafPacientesModel> getPacientes(@RequestHeader(value = "Authorization") String token){

        return rafPacienteDAO.getPacientes();
    }

    @RequestMapping(value = "api/pacientes/{id}", method = RequestMethod.DELETE)
    public void eliminarPacientes(@PathVariable Long id){
        rafPacienteDAO.eliminarPacientes(id);//tratar con String
    }

    @RequestMapping(value = "api/pacientes/crear", method = RequestMethod.POST)
    public void registrarPacientes(@RequestBody RafPacientesModel rafPacientesModel){
        rafPacienteDAO.registrarPaciente(rafPacientesModel);
    }
}
