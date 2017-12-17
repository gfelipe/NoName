package br.uff.controller;

import br.uff.model.Student;
import br.uff.model.User;
import br.uff.model.UserRole;
import br.uff.repository.StudentRepository;
import br.uff.repository.UserRepository;
import br.uff.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collections;

@Controller
@RequestMapping("/minha-conta")
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/cadastrar")
    public String register(@ModelAttribute("student") Student student, HttpServletRequest httpServletRequest) {

        Student savedStudent = studentRepository.save(student);

        if(savedStudent != null) {
            User user = new User();

            user.setUsername(student.getEmail());
            user.setPassword(encodePassword(httpServletRequest.getParameter("password")));
            user.setRoles(Collections.singleton(getStudentRole(user)));

            userRepository.save(user);
        }

        return "login";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user != null) {
            Student student = studentRepository.findByEmail(user.getUsername());
            model.addAttribute("student", student);
        }

        return "detalhes";
    }

    private String encodePassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    private UserRole getStudentRole(User user) {
        UserRole userRole = new UserRole();

        userRole.setRole("ROLE_STUDENT");
        userRole.setUser(user);

        return userRole;
    }
}
