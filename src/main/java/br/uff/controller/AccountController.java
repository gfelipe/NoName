package br.uff.controller;

import br.uff.model.*;
import br.uff.repository.ProjectRepository;
import br.uff.repository.StudentRepository;
import br.uff.service.AcademicPersonService;
import br.uff.service.ProjectService;
import br.uff.service.StudentService;
import br.uff.service.UserService;
import br.uff.util.Course;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/minha-conta")
public class AccountController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private AcademicPersonService academicPersonService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/cadastrar")
    public String register(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        try {
            AcademicPerson person = null;

            if (request.getParameter("type").equals("student")) {
                person = academicPersonService.save(buildStudent(request));
            } else if (request.getParameter("type").equals("professor")) {
                person = academicPersonService.save(buildProfessor(request));
            }

            if (person != null) {

                String password = request.getParameter("password");

                User savedUser = userService.createUserFromPerson(person, password);

                if (savedUser != null && savedUser.isEnabled()) {
                    try {
                        request.login(savedUser.getUsername(), password);
                        return "redirect:/index";
                    } catch (ServletException e) {
                        e.printStackTrace();
                        return "login";
                    }
                } else if (savedUser != null) {
                    redirectAttributes.addFlashAttribute("warn", "Usuário criado. Aguarde a aprovação de um administrador.");
                    return "redirect:/index";
                } else {
                    model.addAttribute("error", "Erro ao salvar usuário.");
                    return "login";
                }

            } else {
                model.addAttribute("error", "Erro ao salvar pessoa.");
                return "login";
            }
        } catch (Exception e) {
            if (e instanceof MySQLIntegrityConstraintViolationException) {
                model.addAttribute("error", "Usuário já existe.");
            } else {
                model.addAttribute("error", "Erro desconhecido.");
            }
            return "login";
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model) {


        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user != null) {
            Student student = academicPersonService.findStudentByEmail(user.getUsername());
            Project project = projectService.findByStudent1(student);

            System.out.println(" = = = = = =" + project + " -= = = = = = = = = = = = =");

            model.addAttribute("person", student);
            model.addAttribute("project", project);

        }

        return "detalhes";
    }


    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String edit(Model model) {

        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Student student = academicPersonService.findStudentByEmail(user.getUsername());
        model.addAttribute("person", student);


        return "edit";
    }


    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String updateUser(HttpServletRequest httpServletRequest){

        Student student = studentService.findByEmail(httpServletRequest.getParameter("email"));

        student.setName(httpServletRequest.getParameter("name"));
        student.setGrade(httpServletRequest.getParameter("grade"));


        studentService.updateStudent(student);

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

    @RequestMapping("valida-cadastro")
    public String getValidaCadastro(Model model){
        List<User> users = this.userService.findUserByEnabled(false);
        model.addAttribute("users",users);
        return "valida-cadastro";
    }

    @RequestMapping(value="valida-cadastro",method=RequestMethod.POST)
    public String validaCadastro(@RequestParam String username, Model model){
        User user = this.userService.findUserByUsername(username);
        user.setEnabled(true);
        this.userService.save(user);
        List<User> users = this.userService.findUserByEnabled(false);
        model.addAttribute("users",users);
        return "valida-cadastro";
    }

}
