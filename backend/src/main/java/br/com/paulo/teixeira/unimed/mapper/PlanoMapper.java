package br.com.paulo.teixeira.unimed.mapper;

import br.com.paulo.teixeira.unimed.model.Plano;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlanoMapper {

    @Select("SELECT * FROM plano")
    List<Plano> findAll();
}
