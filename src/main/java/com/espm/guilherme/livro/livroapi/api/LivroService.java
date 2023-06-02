package com.espm.guilherme.livro.livroapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepo;

    public LivroOutTO inserirLivro(LivroInTO newLivro) {
        LivroModel livro = livroRepo.save(new LivroModel(newLivro));

        return new LivroOutTO(
                livro.getId(), livro.getTitulo(), livro.getAutor(),
                livro.getEditora(), livro.getAno(), livro.getPreco());
    }

    public List<LivroOutTO> listarLivros(String nomeAutor, String tituloLivro) {
        System.out.println(nomeAutor + tituloLivro);
        return livroRepo
                .listarLivros(nomeAutor, tituloLivro)
                .stream()
                .map(m -> new LivroOutTO(m.getId(), m.getTitulo(), m.getAutor(),
                        m.getEditora(), m.getAno(), m.getPreco()))
                .toList();
    }
}
