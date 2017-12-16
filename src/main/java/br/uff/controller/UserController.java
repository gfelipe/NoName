package br.uff.controller;

import br.uff.service.UsuarioService;
import br.uff.model.Usuario;
import br.uff.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/usuario/cadastro")
    public String getCadastro(Model model){

        model.addAttribute("usuario",new Usuario());
        return "cadastro";
    }

    @RequestMapping(value="/usuario/cadastro",method = RequestMethod.POST)
    public String cadastro(Usuario usuario, Model model){

        Usuario usuarioParaSalvar = usuarioService.makeUser(usuario);

        usuarioRepository.save(usuarioParaSalvar);

        return "redirect:/";
    }
}
