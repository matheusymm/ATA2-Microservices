package br.asp.ata2.video.service;

import br.asp.ata2.video.dto.VideoResponseDTO;
import br.asp.ata2.video.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    @Transactional(readOnly = true)
    public VideoResponseDTO findById(Long id) {
        log.info("Buscando video por id: {}", id);
        return videoRepository.findById(id)
                .map(video -> VideoResponseDTO.builder()
                        .id(video.getId())
                        .name(video.getName())
                        .time(video.getTime())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("O id informado não existe"));
    }
}
