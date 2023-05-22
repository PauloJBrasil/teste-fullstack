package br.com.paulo.teixeira.unimed.mapper;

import br.com.paulo.teixeira.unimed.dto.UserDto;
import br.com.paulo.teixeira.unimed.dto.UsuarioDto;
import br.com.paulo.teixeira.unimed.model.Usuario;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UsuarioMapper {

    @Select("SELECT * FROM usuario WHERE id = #{idUsuario}")
    UsuarioDto findById(Long idUsuario);

    @Select("SELECT * FROM usuario WHERE login = #{login}")
    Usuario findByLogin(String login);

    @Insert("INSERT INTO usuario(login, nome, senha)" +
            "VALUES (#{login}, #{name}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(UserDto usuario);

    @Update("UPDATE usuario SET nome = #{usuario.name}, login = #{usuario.login}, senha = #{usuario.password} WHERE id = #{idUsuario}")
    void update(Long idUsuario, UserDto usuario);

    @Delete("DELETE FROM usuario WHERE id = #{idUsuario}")
    void deleteById(Long id);
}
