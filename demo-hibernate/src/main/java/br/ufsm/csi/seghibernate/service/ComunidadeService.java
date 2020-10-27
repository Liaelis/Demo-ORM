package br.ufsm.csi.seghibernate.service;

import br.ufsm.csi.seghibernate.model.Comunidade;
import br.ufsm.csi.seghibernate.repository.ComunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunidadeService {
    @Autowired
    private ComunidadeRepository comunidadeRepository;

    public void save(Comunidade comunidade) {
        comunidadeRepository.save(comunidade);
    }
}
