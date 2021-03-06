package com.socialbooks.socialbooks.services;

import com.socialbooks.socialbooks.domain.Comentario;
import com.socialbooks.socialbooks.domain.Livro;
import com.socialbooks.socialbooks.repository.ComentariosRespository;
import com.socialbooks.socialbooks.repository.LivrosRepository;
import com.socialbooks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private ComentariosRespository comentariosRespository;

    public List<Livro> listar(){
        return livrosRepository.findAll();
    }

    public Livro buscar(Long id){
        Livro livro = livrosRepository.findOne(id);

        if(livro == null){
            throw new LivroNaoEncontradoException("O livro não foi encontrado! ");
        }

        return livro;
    }

    public Livro salvar(Livro livro){
        livro.setId(null);
        return livrosRepository.save(livro);


    }

    public void deletar(Long id){
        try{
            livrosRepository.delete(id);
        }catch (EmptyResultDataAccessException e) {
            throw new LivroNaoEncontradoException("O livro não foi encontrado! ");
        }
    }

    public void atualizar(Livro livro){
        verificarExistencia(livro);
        livrosRepository.save(livro);
    }

    private void verificarExistencia(Livro livro){
        buscar(livro.getId());
    }

    public Comentario salvarComentario(Long livroId, Comentario comentario){
        Livro livro = buscar(livroId);
        comentario.setLivro(livro);

        comentario.setData(new Date());
        return comentariosRespository.save(comentario);

    }

    public List<Comentario> listarComentarios(Long livroId){
        Livro livro = buscar(livroId);
        return livro.getComentarioList();
    }
}
