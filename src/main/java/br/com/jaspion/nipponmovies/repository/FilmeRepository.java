package br.com.jaspion.nipponmovies.repository;

import br.com.jaspion.nipponmovies.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}