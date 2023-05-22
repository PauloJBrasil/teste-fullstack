package br.com.paulo.teixeira.unimed.controller;

import br.com.paulo.teixeira.unimed.model.Plano;
import br.com.paulo.teixeira.unimed.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plano")
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoService planoService;

    @GetMapping
    public List<Plano> getAllPlano() {
        return planoService.getAllPlano();
    }
}
