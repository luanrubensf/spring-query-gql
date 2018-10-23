package com.luanrubensf.springquerygql.controller;

import com.luanrubensf.springquerygql.model.Parecer;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import com.luanrubensf.springquerygql.service.ParecerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pareceres")
public class ParecerController {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private ParecerService service;

    @PostMapping
    @Transactional
    public Parecer save(@RequestBody Parecer parecer) {
        return service.save(parecer);
    }

    @GetMapping("list")
    public List<Parecer> list() {
        return repository.findAll(Parecer.class);
    }

}
