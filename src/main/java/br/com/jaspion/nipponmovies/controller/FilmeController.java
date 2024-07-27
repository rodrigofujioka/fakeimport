package br.com.jaspion.nipponmovies.controller;

import br.com.jaspion.nipponmovies.model.Filme;
import br.com.jaspion.nipponmovies.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeRepository filmeRepository;


    @GetMapping
    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Filme consultarFilmePorId(@PathVariable Long id) throws InterruptedException {
        int minutesToSleep = 2;
        long millisecondsToSleep = minutesToSleep * 60 * 1000;
        Thread.sleep(millisecondsToSleep);
        return filmeRepository.findById(id).orElseThrow();
    }
}