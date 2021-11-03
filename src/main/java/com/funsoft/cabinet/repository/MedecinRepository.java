package com.funsoft.cabinet.repository;

import java.util.List;

import com.funsoft.cabinet.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    // select m from Medecin m where m.specialite =:spec (prepared statement)
    // select * from medecins where specialite='.....'    (SQL Query)
    public List<Medecin> findBySpecialite(String spec);

    // select m from Medecin m where m.specialite =:spec and m.nom =:nom
    public List<Medecin> findBySpecialiteAndNom(String spec,String nom);

    @Query(value = "select m from Medecin m where m.specialite=:spec and (m.nom LIKE :pseudo or m.prenom LIKE :pseudo)")
    public List<Medecin> advanced_search(@Param("spec") String s, @Param("pseudo") String p);
}
