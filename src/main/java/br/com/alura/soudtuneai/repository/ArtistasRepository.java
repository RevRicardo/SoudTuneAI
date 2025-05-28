package br.com.alura.soudtuneai.repository;

import br.com.alura.soudtuneai.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistasRepository extends JpaRepository<Artista, Long> {
}
