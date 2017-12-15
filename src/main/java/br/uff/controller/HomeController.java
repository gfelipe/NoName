package br.uff.controller;

import br.uff.model.Aluno;
import br.uff.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("alunos", alunoRepository.findAll());
        model.addAttribute("name", name);

        return "index";
    }



}
