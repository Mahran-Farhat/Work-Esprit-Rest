package com.funsoft.cabinet.model;

import java.util.List;

public class Recherche {

    private String specialite;
    private String nom;
    private List<Medecin> medecins;

    public Recherche(){

    }
    

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getSpecialite() {
        return this.specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Medecin> getMedecins() {
        return this.medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
}