package br.ufsm.csi.seghibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PAPEIS")
public class Papel {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;

    @ManyToMany(mappedBy = "papeis")
    @JsonIgnore
    private Collection<Ator> atores;


    public Collection<Ator> getAtores() {
        return atores;
    }

    public void setAtores(Collection<Ator> atores) {
        this.atores = atores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
