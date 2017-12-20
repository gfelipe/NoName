package br.uff.controller;

import br.uff.model.AcademicPerson;
import br.uff.model.Student;
import br.uff.service.AcademicPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import static br.uff.util.GraduationWorkType.TCC1;
import static br.uff.util.GraduationWorkType.TCC2;

public abstract class AbstractController {

    @Autowired
    private AcademicPersonService academicPersonService;

    protected AcademicPerson currentPerson() {

        AcademicPerson academicPerson = null;

        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user != null) {
            academicPerson = academicPersonService.findStudentByEmail(user.getUsername());

            if(academicPerson == null) {
                academicPerson = academicPersonService.findProfessorByEmail(user.getUsername());
            }
        }

        return academicPerson;
    }

}
