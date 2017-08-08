package com.socialbooks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq_gen")
    @SequenceGenerator(name = "autor_seq_gen", sequenceName = "autor_id_seq")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "O campo nome não pode ser vazio.")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "Campo nascimento de preenchimento obrigatório.")
    private Date nascimento;

    @NotNull(message = "Campo nacionalidade de preenchimento obrigatório.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Livro> livros;

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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
