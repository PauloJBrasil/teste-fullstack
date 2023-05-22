package br.com.paulo.teixeira.unimed.dto;

import br.com.paulo.teixeira.unimed.model.Plano;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarioDto {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private int idade;
    private Plano plano;
}
