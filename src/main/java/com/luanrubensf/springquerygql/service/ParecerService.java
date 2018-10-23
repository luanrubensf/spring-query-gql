package com.luanrubensf.springquerygql.service;

import com.luanrubensf.springquerygql.model.Parecer;
import com.luanrubensf.springquerygql.model.Processo;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParecerService {

    @Autowired
    private BasicRepository repository;


    @GraphQLQuery(name = "pareceres")
    public List<Parecer> getPareceres(){
        return repository.findAll(Parecer.class);
    }

    @GraphQLQuery(name = "parecer")
    public Parecer getParecerById(@GraphQLArgument(name = "id") Long id) {
        return repository.find(Parecer.class, id);
    }

    @GraphQLMutation(name = "saveParecer")
    public Parecer save(@GraphQLArgument(name = "parecer") Parecer entity) {
        validate();
        return repository.merge(entity);
    }

    private void validate() { }
}
