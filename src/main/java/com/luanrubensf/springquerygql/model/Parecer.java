package com.luanrubensf.springquerygql.model;

import com.luanrubensf.springquerygql.core.ApplicationConstants;
import com.luanrubensf.springquerygql.core.IEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "PARECERES", schema = ApplicationConstants.SCHEMA)
@GenericGenerator(name = "SEQ_PARECERES", strategy = ApplicationConstants.GENERATOR_SEQUENCE,
        parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "SEQ_PARECERES"),
                @org.hibernate.annotations.Parameter(name = "schema", value = ApplicationConstants.SCHEMA)})
public class Parecer implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARECERES")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "I_PROCESSOS")
    @NotNull(message = "O processo deve ser informado")
    private Processo processo;

    @Column(name = "PARECER")
    @Length(max = 1000, message = "O description deve ter no máximo 1000 caracteres")
    private String description;

    @Column(name = "DT_CADASTRO")
    private LocalDate data;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
