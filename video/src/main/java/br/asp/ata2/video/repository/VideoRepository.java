package br.asp.ata2.video.repository;

import br.asp.ata2.video.model.Video;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Optional<Video> findById(Long id);
}