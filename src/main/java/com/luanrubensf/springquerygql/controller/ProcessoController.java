package com.luanrubensf.springquerygql.controller;

import com.luanrubensf.springquerygql.model.Processo;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import com.luanrubensf.springquerygql.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @Autowired
    private BasicRepository repository;

    @PostMapping
    @Transactional
    public Processo post(@RequestBody Processo processo) {
        return processoService.save(processo);
    }

    @GetMapping("list")
    public List<Processo> list() {
        return repository.findAll(Processo.class);
    }
}
