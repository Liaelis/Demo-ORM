package br.ufsm.csi.seghibernate.repository;

import br.ufsm.csi.seghibernate.model.Comunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadeRepository extends JpaRepository<Comunidade, Long> {
}
