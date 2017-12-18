package br.uff.repository;

import br.uff.model.Bibliography;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BibliographyRepository extends PagingAndSortingRepository<Bibliography, Long> {

    List<Bibliography> findAllByAuthorContaining(String s);

    List<Bibliography> findAllByYearContaining(String s);
}
