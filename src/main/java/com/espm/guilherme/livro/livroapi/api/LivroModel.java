package com.espm.guilherme.livro.livroapi.api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "livro")
@NoArgsConstructor
@Getter
@Setter
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "editora")
    private String editora;

    @Column(name = "ano")
    private int ano;

    @Column(name = "preco")
    private double preco;

    public LivroModel(LivroInTO livroInTO) {
        this.titulo = livroInTO.titulo();
        this.autor = livroInTO.autor();
        this.editora = livroInTO.editora();
        this.ano = livroInTO.ano();
        this.preco = livroInTO.preco();
    }

    public LivroModel(String id, String titulo, String autor, String editora, int ano, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.preco = preco;
    }

    public void updateData(LivroInTO livroInTO) {
        this.autor = livroInTO.autor() == null ? this.autor : livroInTO.autor();
        this.titulo = livroInTO.titulo() == null ? this.titulo : livroInTO.titulo();
        this.editora = livroInTO.editora() == null ? this.editora : livroInTO.editora();
        this.ano = livroInTO.ano() == null ? this.ano : livroInTO.ano();
        this.preco = livroInTO.preco() == null ? this.preco : livroInTO.preco();
    }

}
