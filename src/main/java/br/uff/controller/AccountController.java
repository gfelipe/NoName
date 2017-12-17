package br.uff.controller;

import br.uff.model.AcademicPerson;
import br.uff.model.Professor;
import br.uff.model.Student;
import br.uff.model.User;
import br.uff.service.AcademicPersonService;
import br.uff.service.UserService;
import br.uff.util.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/minha-conta")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AcademicPersonService academicPersonService;

    @RequestMapping("/cadastrar")
    public String register(HttpServletRequest httpServletRequest) {

        AcademicPerson person = null;

        if(httpServletRequest.getParameter("type").equals("student")) {
            person = academicPersonService.save(buildStudent(httpServletRequest));
        } else if(httpServletRequest.getParameter("type").equals("professor")) {
            person = academicPersonService.save(buildProfessor(httpServletRequest));
        }

        if(person != null) {

            String password = httpServletRequest.getParameter("password");

            User savedUser = userService.createUserFromPerson(person, password);

            if(savedUser != null) {
                try {
                    httpServletRequest.login(savedUser.getUsername(), password);
                    return "/home";
                } catch (ServletException e) {
                    e.printStackTrace();
                    return "login?error";
                }
            } else {
                return "login?error";
            }

        } else {
            return "login?error";
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user != null) {
            Student student = academicPersonService.findByEmail(user.getUsername());
            model.addAttribute("person", student);
        }

        return "detalhes";
    }

    private Professor buildProfessor(HttpServletRequest httpServletRequest) {
        Professor professor = new Professor();

        professor.setName(httpServletRequest.getParameter("name"));
        professor.setEmail(httpServletRequest.getParameter("email"));
        professor.setSiape(httpServletRequest.getParameter("siape"));
        return professor;
    }

    private Student buildStudent(HttpServletRequest request) {
        Student student = new Student();

        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setCourse(Course.valueOf(request.getParameter("course")));
        student.setEnrollment(request.getParameter("enrollment"));
        student.setGrade(request.getParameter("grade"));
        return student;
    }

}
