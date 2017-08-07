package com.socialbooks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Livro {

    @JsonInclude(Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livros_seq_gen")
//    @SequenceGenerator(name = "livros_seq_gen", sequenceName = "livros_id_seq")
    private Long id;

    @JsonInclude(Include.NON_NULL)
    private String nome;

    @JsonInclude(Include.NON_NULL)
    private Date publicacao;

    @JsonInclude(Include.NON_NULL)
    private String editora;

    @JsonInclude(Include.NON_NULL)
    private String resumo;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "livro")
    private List<Comentario> comentarios;

    @JsonInclude(Include.NON_NULL)
    private String autor;

    public Livro(){

    }

    public Livro(String nome){
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Date publicacao) {
        this.publicacao = publicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<Comentario> getComentarioList() {
        return comentarios;
    }

    public void setComentarioList(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
