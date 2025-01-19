package br.asp.ata2.play.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.asp.ata2.play.model.Play;

public interface PlayRepository extends JpaRepository<Play, Long> {
    
}
