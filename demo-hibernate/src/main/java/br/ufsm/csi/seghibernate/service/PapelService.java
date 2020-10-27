package br.ufsm.csi.seghibernate.service;

import br.ufsm.csi.seghibernate.model.Papel;
import br.ufsm.csi.seghibernate.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PapelService {
    @Autowired
    private PapelRepository papelRepository;

    public void save(Papel papel) {
        papelRepository.save(papel);
    }

    public Papel findById(long id) {
        Optional<Papel> op = papelRepository.findById(id);
        if (op.isEmpty()) {
            System.out.printf("não encontrado");
            return null;
        } else {
            Papel papel = op.get();
            return papel;
        }
    }
}
