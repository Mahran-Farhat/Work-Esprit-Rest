package com.funsoft.cabinet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="medecins")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String prenom;
    private String specialite;

    public Medecin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @OneToMany(mappedBy = "medecin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rv> rdvs;

    public List<Rv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rv> rdvs) {
        this.rdvs = rdvs;
    }
}
