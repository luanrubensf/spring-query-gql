package com.luanrubensf.springquerygql.service;

import com.luanrubensf.springquerygql.model.Processo;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoService {

    @Autowired
    private BasicRepository repository;

    @GraphQLQuery(name = "processos")
    public List<Processo> getProcessos(){
        return repository.findAll(Processo.class);
    }

    @GraphQLQuery(name = "processo")
    public Processo getProcessoById(@GraphQLArgument(name = "id") Long id) {
        return repository.find(Processo.class, id);
    }

    @GraphQLMutation(name = "saveProcesso")
    public Processo save(@GraphQLArgument(name = "processo") Processo entity) {
        validate();
        return repository.merge(entity);
    }

    private void validate() { }
}
