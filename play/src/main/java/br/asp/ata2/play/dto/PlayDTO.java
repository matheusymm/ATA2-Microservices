package br.asp.ata2.play.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayDTO {
    private Long id;
    private String video;
    private Date played_at;
}
