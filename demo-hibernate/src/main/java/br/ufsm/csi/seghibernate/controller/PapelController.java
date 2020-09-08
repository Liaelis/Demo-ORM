package br.ufsm.csi.seghibernate.controller;

import br.ufsm.csi.seghibernate.model.Papel;
import br.ufsm.csi.seghibernate.service.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PapelController {

    @Autowired
    private PapelService papelService;

    @GetMapping("/criaPapel")
    public String criaPapel(String nome, String descricao){
        Papel papel = new Papel();
        papel.setNome(nome);
        papel.setDescricao(descricao);
        papelService.save(papel);
        return "Ok papel criado";
    }

}
