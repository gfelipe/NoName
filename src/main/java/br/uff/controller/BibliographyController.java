package br.uff.controller;

import br.uff.service.BibliographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bibliografia")
public class BibliographyController {

    @Autowired
    private BibliographyService bibliographyService;


}
