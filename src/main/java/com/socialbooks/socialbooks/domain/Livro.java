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
    @Transient
    private List<Comentario> comentarioList;

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
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
