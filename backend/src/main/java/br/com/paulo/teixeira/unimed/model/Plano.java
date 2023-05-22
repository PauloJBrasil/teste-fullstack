package br.com.paulo.teixeira.unimed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plano {

    private long id;

    private String nome;

    private BigDecimal valor;

}
