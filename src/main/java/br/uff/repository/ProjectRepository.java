package br.uff.repository;


import br.uff.model.Project;
import br.uff.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Project findByStudent1(Student student);
}
