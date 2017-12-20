package br.uff.controller;

import br.uff.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DefaultController {

    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/bibliografia")
    public String bibliografia() {
        return "/bibliografia";
    }

    @GetMapping("/cronograma")
    public String cronograma() { return "/cronograma"; }


    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/cadastro")
    public String register(Model model) {
        model.addAttribute("student", new Student());
        return "/cadastro";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}