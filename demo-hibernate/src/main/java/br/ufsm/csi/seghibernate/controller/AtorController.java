package br.ufsm.csi.seghibernate.controller;

import br.ufsm.csi.seghibernate.model.Ator;
import br.ufsm.csi.seghibernate.model.Papel;
import br.ufsm.csi.seghibernate.model.Trabalhador;
import br.ufsm.csi.seghibernate.service.AtorService;
import br.ufsm.csi.seghibernate.service.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AtorController {
    @Autowired
    private AtorService atorService;
    @Autowired
    private PapelService papelService;

    @GetMapping("/getAtores")
    public List<Ator> getAtores() {

        return atorService.listaAtor();
    }

    @GetMapping("/findAtores")
    public List<Ator> getAtoresPapeis(Long[] idPapel) {

        return (List<Ator>) atorService.findByPapeis(idPapel);
    }

    @GetMapping("/criaAtor")
    public String criaPessoa(String cpf,
                             String nome,
                             String endereco,
                             String pisPasep,
                             Long[] idPapel) {
        Ator p = null;
        if (pisPasep != null) {
            p = new Trabalhador();
            ((Trabalhador) p).setPisPasep(pisPasep);

        } else {
            p = new Ator();
        }
        if (idPapel != null && idPapel.length > 0) {
            p.setPapeis(new ArrayList<>());
            for (Long id : idPapel) {
                Papel papel = papelService.findById(id);
                if (papel != null) {
                    p.getPapeis().add(papel);
                }
            }
        }
        p.setCpf(cpf);
        p.setEndereço(endereco);
        p.setNome(nome);
        atorService.criaAtor(p);
        return "OK";
    }
}
