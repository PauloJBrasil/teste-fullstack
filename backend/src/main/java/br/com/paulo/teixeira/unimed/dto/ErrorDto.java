package br.com.paulo.teixeira.unimed.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorDto {

    private String message;

}
