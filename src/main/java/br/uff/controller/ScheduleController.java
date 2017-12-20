package br.uff.controller;

import br.uff.model.Project;
import br.uff.model.Schedule;
import br.uff.model.Student;
import br.uff.service.ProjectService;
import br.uff.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/cronogramas")
public class ScheduleController extends AbstractController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ProjectService projectService;


    @RequestMapping("/cadastrar")
    public String create(Model model, HttpServletRequest request) {
        Student student = (Student) currentPerson();
        List<Project> projects = projectService.listByStudent(student);
        model.addAttribute("projects", projects);

        return "novoCronograma";
    }

    @RequestMapping("/criar")
    public String create(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){

        Student student = (Student) currentPerson();
        Schedule cronograma = new Schedule();

        cronograma.setActivity(request.getParameter("activity"));
        cronograma.setDescription(request.getParameter("description"));
        cronograma.setProject(projectService.findById(Long.valueOf(request.getParameter("project"))));

        try{
            cronograma.setDate(new SimpleDateFormat("dd/MM/YYYY").parse(request.getParameter("date")));
        } catch (ParseException e){
            e.printStackTrace();
        }


        cronograma = scheduleService.save(cronograma);


        if(cronograma == null){
            redirectAttributes.addFlashAttribute("warn", "Cronograma cadastrado com sucesso.");
            return "redirect:/cronogramas";
        } else {
            List<Project> projects = projectService.listByStudent(student);

            model.addAttribute("projects", projects);
            model.addAttribute("error", "Erro ao salvar cronograma.");
            return "novoCronograma";
        }
    }

}
