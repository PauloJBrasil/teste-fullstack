package br.com.paulo.teixeira.unimed.service;

import br.com.paulo.teixeira.unimed.dto.CredentialsDto;
import br.com.paulo.teixeira.unimed.dto.UserDto;
import br.com.paulo.teixeira.unimed.mapper.UsuarioMapper;
import br.com.paulo.teixeira.unimed.model.Usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public Usuario getUsuario(long idUsuario) {
        return usuarioMapper.findById(idUsuario);
    }

    public UserDto authenticate(CredentialsDto credentialsDto) {
        Usuario usuario = usuarioMapper.findByLogin(credentialsDto.getLogin());

        if(usuario == null) {
            throw new RuntimeException("Login não encontrado!");
        }

        if(passwordEncoder.matches(credentialsDto.getPassword(), usuario.getSenha())) {
            UserDto userDto = new UserDto();
            userDto.setId(usuario.getId());
            userDto.setName(usuario.getNome());
            userDto.setLogin(usuario.getLogin());
            return userDto;
        }

        throw new RuntimeException("Senha inválida!");
    }

    public UserDto findByLogin(String login) {
        UserDto userDto = new UserDto();
        Usuario usuario = usuarioMapper.findByLogin(login);

        if( usuario == null) {
            throw new RuntimeException("Login não encontrado!");
        }

        userDto.setId(usuario.getId());
        userDto.setName(usuario.getNome());
        userDto.setLogin(usuario.getLogin());


        return userDto;
    }

    public void signUp(UserDto usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioMapper.save(usuario);
    }
}
