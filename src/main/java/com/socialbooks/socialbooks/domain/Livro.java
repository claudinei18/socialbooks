package com.socialbooks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Livro {

    @JsonInclude(Include.NON_NULL)
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livros_seq_gen")
    @SequenceGenerator(name = "livros_seq_gen", sequenceName = "livros_id_seq")
    private Long id;

    @JsonInclude(Include.NON_NULL)
    @NotEmpty(message = "Campo nome de preenchimento obrigatório..")
    private String nome;

    @JsonInclude(Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date publicacao;

    @JsonInclude(Include.NON_NULL)
    @NotNull(message = "Campo editora de preenchimento obrigatório..")
    private String editora;

    @JsonInclude(Include.NON_NULL)
    @NotNull(message = "Campo resumo de preenchimento obrigatório.")
    @Size(max = 1500, message = "O resumo não pode conter mais de 1500 caracteres.")
    private String resumo;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "livro")
    private List<Comentario> comentarios;

    @JsonInclude(Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    private Autor autor;

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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
