package br.ufsm.csi.seghibernate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRABALHADOR")
public class Trabalhador extends Ator {

    private String pisPasep;

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }
}
