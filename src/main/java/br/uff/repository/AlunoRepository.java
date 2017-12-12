package br.uff.repository;

import br.uff.model.Aluno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> {

}
