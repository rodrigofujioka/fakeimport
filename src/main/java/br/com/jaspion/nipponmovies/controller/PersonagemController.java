package br.com.jaspion.nipponmovies.controller;

import br.com.jaspion.nipponmovies.model.Filme;
import br.com.jaspion.nipponmovies.model.Personagem;
import br.com.jaspion.nipponmovies.repository.PersonagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemRepository personagemRepository;

    @GetMapping
    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Personagem consultarFilmePorId(@PathVariable Long id) {
        return personagemRepository.findById(id).orElseThrow();
    }
}