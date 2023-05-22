package br.com.paulo.teixeira.unimed.service;

import br.com.paulo.teixeira.unimed.model.Plano;
import br.com.paulo.teixeira.unimed.mapper.PlanoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoMapper planoMapper;

    public List<Plano> getAllPlano() {
        return planoMapper.findAll();
    }

    public Plano getPlano(Long idPlano) {
        return planoMapper.findById(idPlano);
    }

    public void criar(Plano plano) {
        planoMapper.insert(plano);
    }

    public void update(Long idPlano, Plano plano) {
        planoMapper.update(idPlano, plano);
    }

    public void delete(Long idPlano) {
        planoMapper.delete(idPlano);
    }
}
