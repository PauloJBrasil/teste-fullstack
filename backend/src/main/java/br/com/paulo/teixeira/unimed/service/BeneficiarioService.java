package br.com.paulo.teixeira.unimed.service;

import br.com.paulo.teixeira.unimed.mapper.BeneficiarioMapper;
import br.com.paulo.teixeira.unimed.model.Beneficiario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {

    private final BeneficiarioMapper beneficiarioMapper;

    public List<Beneficiario> getAllBeneficiario() {
        return beneficiarioMapper.findAll();
    }
}
