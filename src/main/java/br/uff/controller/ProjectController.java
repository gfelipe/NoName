package br.uff.controller;

import br.uff.model.AcademicPerson;
import br.uff.model.Professor;
import br.uff.model.Project;
import br.uff.model.Student;
import br.uff.service.AcademicPersonService;
import br.uff.service.ProjectService;
import br.uff.util.GraduationWorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

import static br.uff.util.GraduationWorkType.TCC1;
import static br.uff.util.GraduationWorkType.TCC2;

@Controller
@RequestMapping("/projetos")
public class ProjectController extends AbstractController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AcademicPersonService academicPersonService;

    @RequestMapping(value = {"", "/"})
    public String index(Model model) {

        Student student = (Student) currentPerson();

        List<Project> project = projectService.listByStudent(student);

        model.addAttribute("firstProject", project.stream().filter( p -> p.getType() == TCC1)
                .findAny().orElse(null));
        model.addAttribute("secondProject", project.stream().filter( p -> p.getType() == TCC2)
                .findAny().orElse(null));
        model.addAttribute("dt", new SimpleDateFormat("dd/MM/YYYY"));

        return "projetos";

    }

    @RequestMapping("/cadastrar")
    public String create(Model model, HttpServletRequest request) {
        List<Professor> professors = academicPersonService.listProfessors();

        model.addAttribute("type", request.getParameter("type"));
        model.addAttribute("professors", professors);

        return "novoProjeto";
    }

    @RequestMapping("/criar")
    public String create(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        Project project = new Project();

        project.setName(request.getParameter("name"));
        project.setType(GraduationWorkType.valueOf(request.getParameter("type")));
        project.setStudent1((Student) currentPerson());
        project.setProfessor(academicPersonService.findProfessorById(Long.valueOf(request.getParameter("professor"))));

        project = projectService.save(project);

        if (project != null) {

            redirectAttributes.addFlashAttribute("warn", "Projeto cadastrado com sucesso.");
            return "redirect:/projetos";

        } else {
            List<Professor> professors = academicPersonService.listProfessors();

            model.addAttribute("type", request.getParameter("type"));
            model.addAttribute("professors", professors);
            model.addAttribute("error", "Erro ao salvar projeto.");

            return "novoProjeto";
        }
    }

}
