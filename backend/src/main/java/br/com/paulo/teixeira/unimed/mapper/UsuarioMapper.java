package br.com.paulo.teixeira.unimed.mapper;

import br.com.paulo.teixeira.unimed.dto.UserDto;
import br.com.paulo.teixeira.unimed.model.Usuario;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UsuarioMapper {

    @Select("SELECT * FROM usuario WHERE id = #{idUsuario}")
    Usuario findById(Long idUsuario);

    @Select("SELECT * FROM usuario WHERE login = #{login}")
    Usuario findByLogin(String login);

    @Insert("INSERT INTO usuario(login, nome, senha)" +
            "VALUES (#{login}, #{name}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(UserDto usuario);

    @Update("UPDATE usuario SET nome = #{nome}, login = #{login}, password = #{password} WHERE id = #{id}")
    void update(UserDto usuario);

    @Delete("DELETE FROM usuario WHERE id = #{idUsuario}")
    void deleteById(Long id);
}
