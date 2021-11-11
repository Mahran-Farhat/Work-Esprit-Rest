package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
