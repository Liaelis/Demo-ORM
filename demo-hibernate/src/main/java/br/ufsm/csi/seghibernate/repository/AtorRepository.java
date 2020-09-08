package br.ufsm.csi.seghibernate.repository;

import br.ufsm.csi.seghibernate.model.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long>, JpaSpecificationExecutor<Ator> {

    @Query("select distinct a  from Ator a join a.papeis p where p.id in (:ids)")
    Collection<Ator> findByPapeis(Long[] ids);
}
