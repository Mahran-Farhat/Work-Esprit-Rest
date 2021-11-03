package com.funsoft.cabinet.service;

import java.util.List;

import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.repository.MedecinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedecinServiceImpl implements MedecinService{


    @Autowired
    MedecinRepository agent;

    @Override
    public void saveorupadte(Medecin m) {
               agent.save(m) ;
    }

    @Override
    public Medecin getById(long id) {

        return agent.findById(id).get();
    }

    @Override
    public void delete(long id) {
        agent.deleteById(id);        
    }

    @Override
    public List<Medecin> consulte() {
        return agent.findAll();
    }

    @Override
    public List<Medecin> recherche_specialite(String spec) {
        return agent.findBySpecialite(spec);
    }

    @Override
    public List<Medecin> recherche_specialite_nom(String spec, String nom) {
        return agent.findBySpecialiteAndNom(spec, nom);
    }

    @Override
    public List<Medecin> recherche_avancee(String spec, String nom) {
        return agent.advanced_search(spec, "%"+nom+"%");
    }
    
}
