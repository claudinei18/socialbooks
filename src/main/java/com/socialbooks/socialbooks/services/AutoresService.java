package com.socialbooks.socialbooks.services;

import com.socialbooks.socialbooks.domain.Autor;
import com.socialbooks.socialbooks.repository.AutoresRepository;
import com.socialbooks.socialbooks.services.exceptions.AutorExistenteException;
import com.socialbooks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

    public Autor salvar(Autor autor){
        if(autor.getId() != null){
            Autor a = autoresRepository.findOne(autor.getId());

            if(a != null){
                throw new AutorExistenteException("O autor já existe!");
            }
        }
        return autoresRepository.save(autor);
    }

    public Autor buscar(Long id){
        Autor autor = autoresRepository.findOne(id);

        if(autor == null){
            throw new AutorNaoEncontradoException("Autor não encontrado!");
        }

        return autor;
    }

}
