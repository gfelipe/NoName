package br.uff.controller;

import br.uff.model.Student;
import br.uff.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 14/12/17.
 */

@Controller
public class AlunoController {

    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping("/alunos")
    public String alunos(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("alunos", studentRepository.findAll());

        return "alunos";
    }


    @RequestMapping("/aluno/{id}")
    public String aluno(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("name", studentRepository.findOne(Long.valueOf(id)).getName());
        return "aluno";
    }
}
