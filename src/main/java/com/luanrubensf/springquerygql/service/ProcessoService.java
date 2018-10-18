package com.luanrubensf.springquerygql.service;

import com.luanrubensf.springquerygql.model.Processo;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessoService {

    @Autowired
    private BasicRepository repository;

    public Processo save(Processo entity) {
        validate();
        return repository.merge(entity);
    }

    private void validate() { }
}
