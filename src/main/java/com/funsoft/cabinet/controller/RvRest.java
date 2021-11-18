package com.funsoft.cabinet.controller;


import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Rv;
import com.funsoft.cabinet.repository.RvRepository;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RvRest {

    @Autowired
    RvRepository agent;

    @Autowired
    ClientService agentcl;

    @Autowired
    MedecinService agentmed;

    @RequestMapping(value = "/rdvs/add",method = RequestMethod.GET)
    public ModelAndView add_rdv(){
        Rv rdv = new Rv();
        List<Client> clients = agentcl.consulte();
        List<Medecin> medecins = agentmed.consulte();
        ModelAndView response = new ModelAndView();
        response.addObject("RdvForm",rdv);
        response.addObject("clients",clients);
        response.addObject("medecins",medecins);
        response.setViewName("rdv");
        return response;
    }

}
