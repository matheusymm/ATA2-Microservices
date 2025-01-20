package br.asp.ata2.play.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.RequiredArgsConstructor;

import br.asp.ata2.play.model.Play;
import br.asp.ata2.play.dto.PlayDTO;
import br.asp.ata2.play.dto.PlayedEventDTO;
import br.asp.ata2.play.dto.VideoResponseDTO;
import br.asp.ata2.play.repository.PlayRepository;

@Service
@RequiredArgsConstructor
public class PlayService {
    private final PlayRepository playRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String, PlayedEventDTO> kafkaTemplate;

    public String play(PlayDTO playDTO) {
        Play play = new Play();

        play.setPlayed_at(playDTO.getPlayed_at());
        play.setVideo(playDTO.getVideo());

        playRepository.save(play);

        VideoResponseDTO video = webClientBuilder.build()
            .get()
            .uri("http://localhost:8084/api/video/" + 1)
            .retrieve()
            .bodyToMono(VideoResponseDTO.class)
            .block();

        kafkaTemplate.send("advertisementTopic", new PlayedEventDTO(play.getId()));
        kafkaTemplate.send("recomendationTopic", new PlayedEventDTO(play.getId()));
        return video.getName() + " played at " + playDTO.getPlayed_at();
    }
}
