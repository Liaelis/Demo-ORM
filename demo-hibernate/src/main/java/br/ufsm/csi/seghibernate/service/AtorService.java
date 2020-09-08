package br.ufsm.csi.seghibernate.service;

import br.ufsm.csi.seghibernate.model.Ator;

import br.ufsm.csi.seghibernate.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public List<Ator> listaAtor(){
    return atorRepository.findAll();
    }

    public void criaAtor(Ator p){
        atorRepository.save(p);
    }


    public  Ator findId(Long id){
        // poderia ser usado atorRepository.getOne(id) joga exception se não existe;
        Optional<Ator> op =atorRepository.findById(id);
        if(op.isEmpty()){
            System.out.printf("não encontrado");
            return null;
        }else{
            Ator ator = op.get();
            return ator;
        }
    }

    public Collection<Ator> findByPapeis(Long[] idPapel){

        return atorRepository.findByPapeis(idPapel);
    }

    private static class AtorSpecs{
        private static Specification<Ator> nome(String n){
            return ((root, criteriaQuery, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("nome"),"%" + n +"%");
            });
        }

        private static Specification<Ator> idadeMinima(int idade){
            return((root, criteriaQuery, criteriaBuilder) ->{

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.YEAR, -idade);
                return criteriaBuilder.lessThanOrEqualTo(root.get("dataNacimento"), cal.getTime());
            });
        }
    }
}
