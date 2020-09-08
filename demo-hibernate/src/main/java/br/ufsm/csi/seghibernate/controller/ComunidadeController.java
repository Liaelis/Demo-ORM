package br.ufsm.csi.seghibernate.controller;

import br.ufsm.csi.seghibernate.model.Ator;
import br.ufsm.csi.seghibernate.model.Comunidade;
import br.ufsm.csi.seghibernate.service.AtorService;
import br.ufsm.csi.seghibernate.service.ComunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComunidadeController {
    @Autowired
    private ComunidadeService comunidadeService;
    @Autowired
    private AtorService atorService;
    @GetMapping("/criacomunidade")
    public String criaComunidade(String nome, String descricao, Long idCriadaPor){

        Comunidade comunidade = new Comunidade();
        comunidade.setDescricao(descricao);
        comunidade.setNome(nome);
        if(idCriadaPor != null){
          comunidade.setCriadaPor(atorService.findId(idCriadaPor));
        }
        comunidadeService.save(comunidade);


        return "Comunidade salva";
    }
}
