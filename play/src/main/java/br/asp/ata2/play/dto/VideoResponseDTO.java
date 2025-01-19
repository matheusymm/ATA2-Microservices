package br.asp.ata2.play.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoResponseDTO {
    private Long id;
    private String name;
    private Float time;
}
