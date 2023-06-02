package com.espm.guilherme.livro.livroapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class LivroResource {

    @Autowired
    LivroService livroService;

    @PostMapping("/insert")
    public ResponseEntity<LivroOutTO> inserirLivro(@RequestBody() LivroInTO newLivro) {
        LivroOutTO livroResponse = livroService.inserirLivro(newLivro);
        return new ResponseEntity<LivroOutTO>(livroResponse, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<LivroOutTO>> listarLivros(
            @RequestParam(name = "author", defaultValue = "") String nomeAutor,
            @RequestParam(name = "title", defaultValue = "") String tituloLivro) {
        List<LivroOutTO> livrosReponse = livroService.listarLivros(nomeAutor, tituloLivro);
        return new ResponseEntity<List<LivroOutTO>>(livrosReponse, HttpStatus.OK);
    }
}
