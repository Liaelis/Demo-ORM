package br.ufsm.csi.seghibernate.model;

import javax.persistence.*;

@Entity
@Table(name="COMUNIDADE")
public class Comunidade {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    @ManyToOne // vai no lado que tem a chave estrangeira
    @JoinColumn(name = "ID_ATOR_CRIADOR")
    private Ator criadaPor;

    public Ator getCriadaPor() {
        return criadaPor;
    }

    public void setCriadaPor(Ator criadaPor) {
        this.criadaPor = criadaPor;
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
