package com.funsoft.cabinet.service;

import java.util.List;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired // Automatic write and read ( injection d'un objet)
    ClientRepository agent;

    @Override
    public void saveorupdate(Client c) {
        
        agent.save(c);
        // mail de confirmation
    }

    @Override
    public Client getById(long idc) {
        return agent.findById(idc).get();
    }

    @Override
    public void delete(long idc) {
        agent.deleteById(idc);  
        // je dois l'archiver       
    }

    @Override
    public List<Client> consulte() {
        return (List<Client>) agent.findAll();
    }
    
}
