package br.com.paulo.teixeira.unimed.mapper;

import br.com.paulo.teixeira.unimed.model.Beneficiario;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BeneficiarioMapper {

    @Select("SELECT * FROM beneficiario")
    List<Beneficiario> findAll();
}
