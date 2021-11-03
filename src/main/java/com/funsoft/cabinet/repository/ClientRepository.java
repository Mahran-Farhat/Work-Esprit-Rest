package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
    
}
