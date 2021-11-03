package com.funsoft.cabinet.service;

import java.util.List;

import com.funsoft.cabinet.model.Medecin;

public interface MedecinService {
    
    public void saveorupadte(Medecin m);
    public Medecin getById(long id);
    public void delete(long id);
    public List<Medecin> consulte();
    public List<Medecin> recherche_specialite(String spec);
    public List<Medecin> recherche_specialite_nom(String spec,String nom);
    public List<Medecin> recherche_avancee(String spec,String nom);


}
