package br.uff.service;

import br.uff.model.Project;
import br.uff.model.Student;
import br.uff.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> listByStudent(Student student) {
        return projectRepository.findAllByStudent1(student);
    }

    public Project findByStudent1(Student student) {
        return projectRepository.findByStudent1(student);
    }

    public Project findById(Long id){
        return projectRepository.findOne(id);
    }


    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects;

    }


}
