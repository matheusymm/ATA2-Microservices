package br.asp.ata2.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import br.asp.ata2.play.dto.PlayedEventDTO;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayApplication.class, args);
	}

	// @KafkaListener(topics = "playTopic")
	// public void handlePlay(PlayedEventDTO playedEventDTO) {
	// 	log.info("Advertisement received: {}", playedEventDTO.getId());
	// }
}
