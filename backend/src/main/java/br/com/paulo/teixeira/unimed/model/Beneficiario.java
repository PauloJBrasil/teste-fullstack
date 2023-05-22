package br.com.paulo.teixeira.unimed.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiario {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private int idade;

    private Plano plano;

}
