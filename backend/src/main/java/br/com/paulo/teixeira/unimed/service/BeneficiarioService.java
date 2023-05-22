package br.com.paulo.teixeira.unimed.service;

import br.com.paulo.teixeira.unimed.dto.BeneficiarioDto;
import br.com.paulo.teixeira.unimed.mapper.BeneficiarioMapper;
import br.com.paulo.teixeira.unimed.model.Beneficiario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {

    private final BeneficiarioMapper beneficiarioMapper;

    public List<BeneficiarioDto> getAllBeneficiario() {
        return beneficiarioMapper.findAll();
    }

    public BeneficiarioDto getBeneficiarioById(Long idBeneficiario) {
        return beneficiarioMapper.findById(idBeneficiario);
    }

    public void criar(Beneficiario beneficiario) {
        beneficiarioMapper.insert(beneficiario);
    }

    public void update(Long idBeneficiario, Beneficiario beneficiario) {
        beneficiarioMapper.update(idBeneficiario, beneficiario);
    }

    public void delete(Long idBeneficiario) {
        beneficiarioMapper.delete(idBeneficiario);
    }
}
