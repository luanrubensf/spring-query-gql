package com.luanrubensf.springquerygql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanrubensf.springquerygql.core.ApplicationConstants;
import com.luanrubensf.springquerygql.core.IEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Entide que define o Processo
 */
@Entity
@Table(name = "PROCESSOS", schema = ApplicationConstants.SCHEMA)
@GenericGenerator(name = "SEQ_PROCESSOS", strategy = ApplicationConstants.GENERATOR_SEQUENCE,
        parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "SEQ_PROCESSOS"),
                @org.hibernate.annotations.Parameter(name = "schema", value = ApplicationConstants.SCHEMA)})
public class Processo implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESSOS")
    private Long id;

    @NotNull(message = "O nome do processo não pode ser nulo")
    @Column(name = "NAME")
    @Length(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String name;

    @NotNull(message = "A descrição do processo não pode ser nulo")
    @Column(name = "DESCRIPTION")
    @Length(max = 1000, message = "A descricao deve ter no máximo 1000 caracteres")
    private String description;

    @OneToMany(mappedBy = "processo", fetch = FetchType.LAZY)
    private List<Parecer> pareceres;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore //to avoid recursive calls
    public List<Parecer> getPareceres() {
        return pareceres;
    }

}
