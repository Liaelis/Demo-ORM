package br.ufsm.csi.seghibernate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ESTUDANTES")
public class Estudante extends Ator {

    private String matricula;
    private String curso;
    private String instituicao;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
