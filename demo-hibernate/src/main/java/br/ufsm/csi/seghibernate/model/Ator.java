package br.ufsm.csi.seghibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)//para mapear herança
@Table(name = "ATORES")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ATOR")
    @SequenceGenerator(name = "SEQ_aTOR", sequenceName = "SEQ_ATOR")
    private Long id;
    private String cpf;
    private String nome;
    private String endereço;
    private Date dataNascimento;
    @OneToMany(mappedBy = "criadaPor")//nome da propriedade que referencia a classe do outro lado
    @JsonIgnore
    private Collection<Comunidade> comunidadesCriadas;

    @ManyToMany
    //vai gerar tabela de ligação
    @JoinTable(name = "PAPEIS_ATORES", joinColumns = {@JoinColumn(name = "ID_ATOR")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PAPEL")}) //mapeia os id das duas tabelas que geram a nova
    private Collection<Papel> papeis;

    public Collection<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(Collection<Papel> papeis) {
        this.papeis = papeis;
    }

    public Collection<Comunidade> getComunidadesCriadas() {
        return comunidadesCriadas;
    }

    public void setComunidadesCriadas(Collection<Comunidade> comunidadesCriadas) {
        this.comunidadesCriadas = comunidadesCriadas;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
