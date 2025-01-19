package br.asp.ata2.advertisement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import br.asp.ata2.advertisement.dto.PlayedEventDTO;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AdvertisementApplication {
	// @Autowired
	// private KafkaTemplate<String, PlayedEventDTO> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AdvertisementApplication.class, args);
	}

	@KafkaListener(topics = "advertisementTopic")
	public void handlePlay(PlayedEventDTO playedEventDTO) {
		log.info("Advertisement solicitaion received: {}", playedEventDTO.getId(), playedEventDTO.getPlayedAt());
		// kafkaTemplate.send("playTopic", playedEventDTO.getId());
	}
}
