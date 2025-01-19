package br.asp.ata2.recomendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import br.asp.ata2.recomendation.dto.PlayedEventDTO;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class RecomendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendationApplication.class, args);
	}

	@KafkaListener(topics = "recomendationTopic")
	public void handleRecomendation(PlayedEventDTO playedEventDTO) {
		log.info("Recomendation info received: {}", playedEventDTO.getId(), playedEventDTO.getPlayedAt());
	}
}
