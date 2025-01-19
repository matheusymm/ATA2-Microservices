package br.asp.ata2.advertisement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayedEventDTO {
    private String id;
    private Date playedAt;
}
