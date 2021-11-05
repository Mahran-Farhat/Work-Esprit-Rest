package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PatientRest {

    @Autowired
    ClientService agent;

    @RequestMapping(value = "/clients/add",method = RequestMethod.GET)
    public ModelAndView form_add_patient(){
        ModelAndView model = new ModelAndView();
        Client c = new Client();
        model.addObject("FormClient",c);
        model.setViewName("add_client");
        return model;
    }

    @RequestMapping(value = "/clients/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("FormClient") Client client){
        agent.saveorupdate(client);
        return new ModelAndView("redirect:/clients/list");
    }

    @RequestMapping(value = "/clients/list",method = RequestMethod.GET)
    public ModelAndView liste_clients(){
        List<Client> clients = agent.consulte();

        ModelAndView model = new ModelAndView();
        model.addObject("clients",clients);
        model.setViewName("mes_clients");
        return model;
    }

    @RequestMapping(value = "/clients/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete_client(@PathVariable("id") long id){

        agent.delete(id);
        return new ModelAndView("redirect:/clients/list");

    }
}
