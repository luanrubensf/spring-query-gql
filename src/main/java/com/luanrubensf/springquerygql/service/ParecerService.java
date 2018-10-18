package com.luanrubensf.springquerygql.service;

import com.luanrubensf.springquerygql.model.Parecer;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParecerService {

    @Autowired
    private BasicRepository repository;

    public Parecer save(Parecer entity) {
        validate();
        return repository.merge(entity);
    }

    private void validate() { }
}
