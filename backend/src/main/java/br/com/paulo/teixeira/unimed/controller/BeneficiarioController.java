package br.com.paulo.teixeira.unimed.controller;

import br.com.paulo.teixeira.unimed.model.Beneficiario;
import br.com.paulo.teixeira.unimed.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Beneficiario> getAllBeneficiario() {
        return beneficiarioService.getAllBeneficiario();
    }
}
