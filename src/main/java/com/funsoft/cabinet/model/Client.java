package com.funsoft.cabinet.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="clients") // pour renomer la table
public class Client {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min=3,max=10,message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+",message="le nom ne doit que des alphabets")
    @Column(name = "nom_client") // pour modifier le nom de la colonne de la table
    private String nom;

    @NotEmpty
    @Size(min=3,max=10,message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+",message="le prenom ne doit que des alphabets")
    @Column(name = "prenom_client")
    private String prenom;



    public Client() {
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

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rv> rdvs;

    public List<Rv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rv> rdvs) {
        this.rdvs = rdvs;
    }
}
