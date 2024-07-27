package br.com.jaspion.nipponmovies.repository;

import br.com.jaspion.nipponmovies.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}