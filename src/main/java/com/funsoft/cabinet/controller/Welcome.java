package com.funsoft.cabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Welcome {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView welcome(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

}
