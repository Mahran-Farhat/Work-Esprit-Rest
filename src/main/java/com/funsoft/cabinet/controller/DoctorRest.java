package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.exception.ResourceNotFound;
import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Recherche;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DoctorRest {

    @Autowired
    MedecinService agent;


    @GetMapping("/medecins")
    public List<Medecin> list_medecins(){

        return agent.consulte();
    }


    @PostMapping("/medecins")
    public String add_medecin(@RequestBody Medecin medecin){
         agent.saveorupadte(medecin);
         return "medecin ajouté avec succes";
    }

    @GetMapping("/medecins/{id}")
    public Medecin gent_medecin(@PathVariable("id") long id) throws ResourceNotFound{

        Medecin medecin =  agent.getById(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id :"+id)
        );

        return medecin;
    }

    @DeleteMapping("/medecins/{id}")
    public String delete_medecin(@PathVariable("id") long id) throws ResourceNotFound{

        Medecin medecin = agent.getById(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id : "+id)
        );
        agent.delete(id);
        return "Deleted : True";
    }

    @PutMapping("/medecins/{id}")
    public String update_medecin(@PathVariable("id") long id,@RequestBody Medecin medecin) throws ResourceNotFound{

        Medecin med = agent.getById(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id : "+id)
        );

        med.setNom(medecin.getNom());
        med.setPrenom(medecin.getPrenom());
        med.setSpecialite(medecin.getSpecialite());
        agent.saveorupadte(med);
        return "medecin mis à jour";
    }
}
