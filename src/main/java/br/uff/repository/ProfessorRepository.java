package br.uff.repository;

import br.uff.model.Professor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {

    Professor findByEmail(String email);
}
