package br.asp.ata2.play.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.asp.ata2.play.dto.PlayDTO;
import br.asp.ata2.play.service.PlayService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/play")
@RequiredArgsConstructor
@Transactional
public class PlayController {
    private final PlayService playService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "play", fallbackMethod = "fallback")
    @TimeLimiter(name = "play")
    @Retry(name = "play")
    public CompletableFuture<String> handlePlay(@RequestBody PlayDTO playDTO) {
        return CompletableFuture.supplyAsync(() -> playService.play(playDTO));
    }

    public CompletableFuture<String> fallback(PlayDTO playDTO, Throwable throwable) {
        return CompletableFuture.completedFuture("Play failed: " + throwable.getMessage());
    }
}
