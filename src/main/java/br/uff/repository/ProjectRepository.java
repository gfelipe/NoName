package br.uff.repository;


import br.uff.model.Project;
import br.uff.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Project findByStudent1(Student student);

    List<Project> findAllByStudent1(Student student);
}
