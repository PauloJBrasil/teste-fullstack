package br.com.paulo.teixeira.unimed.controller;

import br.com.paulo.teixeira.unimed.dto.BeneficiarioDto;
import br.com.paulo.teixeira.unimed.model.Beneficiario;
import br.com.paulo.teixeira.unimed.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BeneficiarioDto> getAllBeneficiario() {
        return beneficiarioService.getAllBeneficiario();
    }

    @GetMapping("/{idBeneficiario}")
    public BeneficiarioDto getBeneficiarioById(@PathVariable Long idBeneficiario) {
        return beneficiarioService.getBeneficiarioById(idBeneficiario);
    }

    @PostMapping
    public void criar(@RequestBody Beneficiario beneficiario) {
        beneficiarioService.criar(beneficiario);
    }

    @PutMapping("/{idBeneficiario}")
    public void update(@PathVariable("idBeneficiario") Long idBeneficiario, @RequestBody Beneficiario beneficiario) {
        beneficiarioService.update(idBeneficiario, beneficiario);
    }

    @DeleteMapping("/{idBeneficiario}")
    public void delete(@PathVariable Long idBeneficiario) {
        beneficiarioService.delete(idBeneficiario);
    }
}
