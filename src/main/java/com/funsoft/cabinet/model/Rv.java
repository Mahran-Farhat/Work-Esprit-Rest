package com.funsoft.cabinet.model;

import javax.persistence.*;

@Entity
@Table(name="rv")
public class Rv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jour;

    @JoinColumn(name="ID_Medecin",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medecin medecin;

    @JoinColumn(name = "ID_Client",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client client;

    public Rv() {
        this.client = new Client(); // pour avoir de l'espace mémoire (client.id)
        this.medecin = new Medecin();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
