package com.semillero.pruebaSemillero.controllers;

import com.semillero.pruebaSemillero.dao.RafPersonaDAO;
import com.semillero.pruebaSemillero.models.RafPersonasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RafPersonaController {

    @Autowired
    private RafPersonaDAO rafPersonaDAO;

    @RequestMapping(value = "api/persona/crear", method = RequestMethod.POST)
    public void registrarPersona(@RequestBody RafPersonasModel rafPersonasModel){
        rafPersonaDAO.registrarPersona(rafPersonasModel);
    }

    @RequestMapping(value = "api/persona/update/{id}", method = RequestMethod.PUT)
    public void actualizarPersona(@PathVariable Long id,
                                  @RequestBody RafPersonasModel rafPersonasModel){
        rafPersonaDAO.actualizarPersona(id, rafPersonasModel);
    }

    @RequestMapping(value = "api/getPersonaId/{id}", method = RequestMethod.GET)
    public Optional<RafPersonasModel> getPersonaId(@PathVariable Long id){
        return rafPersonaDAO.getPersonaId(id);
    }
}
