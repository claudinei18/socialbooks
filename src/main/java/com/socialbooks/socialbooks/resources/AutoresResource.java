package com.socialbooks.socialbooks.resources;

import com.socialbooks.socialbooks.domain.Autor;
import com.socialbooks.socialbooks.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/autores")
public class AutoresResource {

    @Autowired
    private AutoresService autoresService;

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<List<Autor>> listar(){
        List<Autor> autores = autoresService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(autores);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor){
        autor = autoresService.salvar(autor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Autor> buscar(@PathVariable("id") Long id){
        Autor autor = autoresService.buscar(id);

        return ResponseEntity.status(HttpStatus.OK).body(autor);
    }
}
