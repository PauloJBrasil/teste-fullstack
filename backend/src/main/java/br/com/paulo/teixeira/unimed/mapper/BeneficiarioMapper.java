package br.com.paulo.teixeira.unimed.mapper;

import br.com.paulo.teixeira.unimed.dto.BeneficiarioDto;
import br.com.paulo.teixeira.unimed.model.Beneficiario;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BeneficiarioMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nome", column = "nome"),
            @Result(property = "cpf", column = "cpf"),
            @Result(property = "email", column = "email"),
            @Result(property = "idade", column = "idade"),
            @Result(property = "plano.id", column = "plano_id"),
            @Result(property = "plano.nome", column = "plano_nome"),
            @Result(property = "plano.valor", column = "plano_valor")
    })
    @Select("SELECT beneficiario.*, plano.id AS plano_id, plano.nome AS plano_nome, plano.valor AS plano_valor " +
            "FROM beneficiario " +
            "LEFT JOIN plano ON beneficiario.plano_id = plano.id")
    List<BeneficiarioDto> findAll();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nome", column = "nome"),
            @Result(property = "cpf", column = "cpf"),
            @Result(property = "email", column = "email"),
            @Result(property = "idade", column = "idade"),
            @Result(property = "plano.id", column = "plano_id"),
            @Result(property = "plano.nome", column = "plano_nome"),
            @Result(property = "plano.valor", column = "plano_valor")
    })
    @Select("SELECT beneficiario.*, plano.id AS plano_id, plano.nome AS plano_nome, plano.valor AS plano_valor " +
            "FROM beneficiario " +
            "LEFT JOIN plano ON beneficiario.plano_id = plano.id " +
            "WHERE beneficiario.id = #{idBeneficiario} " )
    BeneficiarioDto findById(Long idBeneficiario);

    @Insert("INSERT INTO beneficiario (nome, cpf, email, idade, plano_id) VALUES (#{nome}, #{cpf}, #{email}, #{idade}, #{plano_id})")
    void insert(Beneficiario beneficiario);

    @Update("UPDATE beneficiario SET nome = #{beneficiario.nome}, cpf = #{beneficiario.cpf}, email = #{beneficiario.email}, idade = #{beneficiario.idade}, plano_id = #{beneficiario.plano_id} WHERE id = #{idBeneficiario}")
    void update(Long idBeneficiario, Beneficiario beneficiario);

    @Delete("DELETE FROM beneficiario WHERE id = #{idBeneficiario}")
    void delete(Long idBeneficiario);

}
