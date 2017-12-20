package br.uff.service;

import br.uff.model.AcademicPerson;
import br.uff.model.Professor;
import br.uff.model.Student;
import br.uff.repository.ProfessorRepository;
import br.uff.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AcademicPersonService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public AcademicPerson save(Student student) {
        return studentRepository.save(student);
    }

    public AcademicPerson save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Student findStudentByEmail(String email) { return studentRepository.findByEmail(email); }public Professor findProfessorByEmail(String email) { return professorRepository.findByEmail(email); }

    public List<Professor> listProfessors() {
        List<Professor> professors = new ArrayList<>();

        Iterator<Professor> iterator = professorRepository.findAll(new Sort("name")).iterator();

        while (iterator.hasNext()) {
            professors.add(iterator.next());
        }

        return professors;
    }

    public Student findStudentById(Long studentId) {
        return studentRepository.findOne(studentId);
    }

    public Professor findProfessorById(Long professorId) {
        return professorRepository.findOne(professorId);
    }
}
