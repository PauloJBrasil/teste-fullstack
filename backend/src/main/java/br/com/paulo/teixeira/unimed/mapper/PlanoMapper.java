package br.com.paulo.teixeira.unimed.mapper;

import br.com.paulo.teixeira.unimed.model.Plano;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlanoMapper {

    @Select("SELECT * FROM plano")
    List<Plano> findAll();
    @Select("SELECT * FROM plano WHERE id = #{idPlano}")
    Plano findById(Long idPlano);

    @Insert("INSERT INTO plano (nome, valor) VALUES (#{nome}, #{valor})")
    void insert(Plano plano);

    @Update("UPDATE plano SET nome = #{plano.nome}, valor = #{plano.valor} WHERE id = #{idPlano}")
    void update(Long idPlano, Plano plano);

    @Delete("DELETE FROM plano WHERE id = #{idPlano}")
    void delete(Long idPlano);
}
