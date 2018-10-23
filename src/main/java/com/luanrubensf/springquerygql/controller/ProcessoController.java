package com.luanrubensf.springquerygql.controller;

import com.luanrubensf.springquerygql.core.pagination.Page;
import com.luanrubensf.springquerygql.core.pagination.Pageable;
import com.luanrubensf.springquerygql.model.Processo;
import com.luanrubensf.springquerygql.model.QParecer;
import com.luanrubensf.springquerygql.model.QProcesso;
import com.luanrubensf.springquerygql.repository.BasicRepository;
import com.luanrubensf.springquerygql.service.ProcessoService;
import com.mysema.query.group.GroupBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("page")
    public Page<Processo> page(@RequestParam(value = "limit", required = false) Integer limit,
                               @RequestParam(value = "offset", required = false) Long offset) {
        Pageable pageable = Pageable.of(limit, offset);
        return repository.findAll(Processo.class, pageable);
    }

    @GetMapping("join")
    public List<Processo> join(@RequestParam("parecer") String parecer) {
        return repository.from(QProcesso.processo)
                .leftJoin(QProcesso.processo.pareceres, QParecer.parecer)
                .where(QParecer.parecer.description.like(parecer))
                .distinct()
                .list(QProcesso.processo);
    }

    @GetMapping("auto-query")
    public List<Processo> autoQuery(@RequestParam("parecer") String parecer) {
        return repository.from(QProcesso.processo)
                .where(QProcesso.processo.pareceres.any().description.like(parecer))
                .list(QProcesso.processo);
    }

    @GetMapping("group-by")
    public Map<String, Long> groupBy() {
         return repository.from(QProcesso.processo)
                 .groupBy(QProcesso.processo.name)
                 .transform(GroupBy.groupBy(QProcesso.processo.name).as(QProcesso.processo.id.count()));
    }
}
