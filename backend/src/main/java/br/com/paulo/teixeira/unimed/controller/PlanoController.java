package br.com.paulo.teixeira.unimed.controller;

import br.com.paulo.teixeira.unimed.model.Plano;
import br.com.paulo.teixeira.unimed.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idPlano}")
    public Plano getPlano(@PathVariable("idPlano") Long idPlano) {
        return planoService.getPlano(idPlano);
    }

    @PostMapping
    public void criar(@RequestBody Plano plano) {
        planoService.criar(plano);
    }

    @PutMapping("/{idPlano}")
    public void update(@PathVariable("idPlano") Long idPlano,
                       @RequestBody Plano plano) {
        planoService.update(idPlano, plano);
    }

    @DeleteMapping("/{idPlano}")
    public void delete(@PathVariable("idPlano") Long idPlano) {
        planoService.delete(idPlano);
    }
}
