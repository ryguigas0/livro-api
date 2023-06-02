package com.espm.guilherme.livro.livroapi.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackofficeResource {

    @GetMapping("/backoffice")
    public String acessarBackoffice(){
        return "backoffice";
    }

}
