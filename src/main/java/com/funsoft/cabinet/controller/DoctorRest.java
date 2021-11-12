package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Recherche;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DoctorRest {

    @Autowired
    MedecinService agent;

    @RequestMapping(value = "/doctors/add",method = RequestMethod.GET)
    public ModelAndView add_doctor(){
        Medecin med = new Medecin();
        ModelAndView rep = new ModelAndView();
        rep.addObject("MedecinForm",med);
        rep.setViewName("add_medecin");
        return rep;
    }

    @RequestMapping(value = "/doctors/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("MedecinForm") Medecin medecin){
        agent.saveorupadte(medecin);
        return new ModelAndView("redirect:/doctors/list");
    }

    @RequestMapping(value="/doctors/list", method=RequestMethod.GET)
    public ModelAndView consulte() {
        List<Medecin> meds = agent.consulte();
        ModelAndView model = new ModelAndView();
        model.addObject("medecins",meds);
        model.setViewName("mes_medecins");
        return model;

    }

    @RequestMapping(value = "/doctors/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id){
        agent.delete(id);
        return new ModelAndView("redirect:/doctors/list");
    }

    @RequestMapping(value = "/doctors/update/{id}",method = RequestMethod.GET)
    public ModelAndView update_doctor(@PathVariable("id") long id){
        Medecin med = agent.getById(id);
        ModelAndView rep = new ModelAndView();
        rep.addObject("MedecinForm",med);
        rep.setViewName("add_medecin");
        return rep;
    }

    @RequestMapping(value = "/doctors/recherche",method = RequestMethod.GET)
    public ModelAndView form_recherche(){
        ModelAndView rep = new ModelAndView();
        Recherche res = new Recherche();
        rep.addObject("resForm",res);
        rep.setViewName("recherche");
        return rep;
    }

    @RequestMapping(value = "/doctors/rechspec",method = RequestMethod.POST)
    public ModelAndView recherche_spec(@ModelAttribute("resForm") Recherche res){

        ModelAndView rep = new ModelAndView();
        List<Medecin> medecins = agent.recherche_specialite(res.getSpecialite());
        res.setMedecins(medecins);
        rep.addObject("resForm",res);
        rep.setViewName("recherche");
        return rep;

    }

    @RequestMapping(value = "/doctors/avancee",method = RequestMethod.GET)
    public ModelAndView form_recherche_avancee(){
        ModelAndView rep = new ModelAndView();
        Recherche res = new Recherche();
        rep.addObject("resForm",res);
        rep.setViewName("recherche_avancee");
        return rep;
    }

    @RequestMapping(value = "/doctors/rechavancee",method = RequestMethod.POST)
    public ModelAndView recherche_avancee(@ModelAttribute("resForm") Recherche res){

        ModelAndView rep = new ModelAndView();
        List<Medecin> medecins = agent.recherche_avancee(res.getSpecialite(),"%"+res.getNom()+"%");
        res.setMedecins(medecins);
        rep.addObject("resForm",res);
        rep.setViewName("recherche_avancee");
        return rep;

    }

}
