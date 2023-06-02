package com.espm.guilherme.livro.livroapi.api;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LivroRepository extends CrudRepository<LivroModel, String> {

    @Query(nativeQuery = true, value = "select * from livro where lower(autor) like lower(concat('%', :autor, '%')) and lower(titulo) like lower(concat('%', :titulo, '%'))")
    List<LivroModel> listarLivros(@Param("autor") String nomeAutor, @Param("titulo") String tituloLivro);

}