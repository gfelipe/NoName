package br.uff.service;

import br.uff.model.Project;
import br.uff.model.Student;
import br.uff.repository.ProjectRepository;
import br.uff.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project findByStudent1(Student student) {

        return projectRepository.findByStudent1(student);
    }

}
