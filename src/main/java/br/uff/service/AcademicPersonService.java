package br.uff.service;

import br.uff.model.AcademicPerson;
import br.uff.model.Professor;
import br.uff.model.Student;
import br.uff.repository.ProfessorRepository;
import br.uff.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Student findByEmail(String email) { return studentRepository.findByEmail(email); }
}
