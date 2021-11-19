package com.funsoft.cabinet.controller;


import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Rv;
import com.funsoft.cabinet.repository.RvRepository;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @RequestMapping(value = "/rdvs/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("RdvForm") Rv rdv){
        Medecin med = agentmed.getById(rdv.getMedecin().getId());
        rdv.setMedecin(med);
        Client client = agentcl.getById(rdv.getClient().getId());
        rdv.setClient(client);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(rdv.getSjour().replace("T"," "), formatter);
        rdv.setJour(date);

        agent.save(rdv);
         return new ModelAndView("redirect:/");

    }
}
