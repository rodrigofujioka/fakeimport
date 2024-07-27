package br.com.jaspion.nipponmovies;

import br.com.jaspion.nipponmovies.model.Aluno;
import br.com.jaspion.nipponmovies.model.Filme;
import br.com.jaspion.nipponmovies.model.Personagem;
import br.com.jaspion.nipponmovies.repository.AlunoRepository;
import br.com.jaspion.nipponmovies.repository.FilmeRepository;
import br.com.jaspion.nipponmovies.repository.PersonagemRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final FilmeRepository filmeRepository;
    private final PersonagemRepository personagemRepository;
    private final AlunoRepository alunoRepository;
    private
    Faker faker = new Faker(new Locale("en-US"));

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("en-US"));
        for (int i = 0; i < 1000; i++) {
            Filme filme = new Filme();
            filme.setTitulo(faker.book().title());
            filme.setDiretor(faker.name().fullName());
            filme.setAno(faker.number().numberBetween(1980, 2020));
            filmeRepository.save(filme);
        }
        for (int i = 0; i < 1000; i++) {
            Personagem personagem = new Personagem();

            if(i%2==0){
                personagem.setNome(faker.dragonBall().character());
            }else{
                personagem.setNome(faker.gameOfThrones().character());
            }
            personagemRepository.save(personagem);
        }
        for (int i = 0; i < 1000; i++) {
            Aluno aluno = new Aluno();

            if(i%2==0){
                aluno.setName(faker.harryPotter().character());
            }else{
                aluno.setName(faker.gameOfThrones().character());
            }
            alunoRepository.save(aluno);
        }
    }

    public Personagem getPersonagem(boolean ehDragonBall){

        return ehDragonBall ? Personagem.builder().nome(faker.dragonBall().character()).build() :
                Personagem.builder().nome(faker.gameOfThrones().character()).build();
    }


}