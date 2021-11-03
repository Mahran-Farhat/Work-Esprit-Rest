package com.funsoft.cabinet.service;

import java.util.List;

import com.funsoft.cabinet.model.Client;

public interface ClientService {

    public void saveorupdate(Client c);
    public Client getById(long idc);
    public void delete(long idc);
    public List<Client> consulte();
    
}
