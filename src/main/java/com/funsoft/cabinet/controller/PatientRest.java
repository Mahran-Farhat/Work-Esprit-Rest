package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientRest {

    @RequestMapping(value = "/clients/add",method = RequestMethod.GET)
    public ModelAndView form_add_patient(){
        ModelAndView model = new ModelAndView();
        Client c = new Client();
        model.addObject("FormClient",c);
        model.setViewName("add_client");
        return model;
    }
}
