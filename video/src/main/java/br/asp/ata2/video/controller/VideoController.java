package br.asp.ata2.video.controller;

import br.asp.ata2.video.dto.VideoResponseDTO;
import br.asp.ata2.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("api/video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VideoResponseDTO findById(@PathVariable Long id) {
        return videoService.findById(id);
    }
}
