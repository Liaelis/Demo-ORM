package br.ufsm.csi.seghibernate.repository;

import br.ufsm.csi.seghibernate.model.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {

}
