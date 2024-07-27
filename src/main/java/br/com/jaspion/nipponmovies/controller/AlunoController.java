package br.com.jaspion.nipponmovies.controller;

import br.com.jaspion.nipponmovies.model.Aluno;
import br.com.jaspion.nipponmovies.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno consultarFilmePorId(@PathVariable Long id) throws InterruptedException {
        int minutesToSleep = 2;
        long millisecondsToSleep = minutesToSleep * 60 * 1000;
        Thread.sleep(millisecondsToSleep);
        return alunoRepository.findById(id).orElseThrow();
    }
}