package br.com.paulo.teixeira.unimed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private long id;

    private String login;

    private String nome;

    private String senha;

}
