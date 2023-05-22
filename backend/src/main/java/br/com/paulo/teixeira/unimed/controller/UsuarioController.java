package br.com.paulo.teixeira.unimed.controller;

import br.com.paulo.teixeira.unimed.config.UserAuthenticationProvider;
import br.com.paulo.teixeira.unimed.dto.UserDto;
import br.com.paulo.teixeira.unimed.dto.UsuarioDto;
import br.com.paulo.teixeira.unimed.model.Usuario;
import br.com.paulo.teixeira.unimed.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto getUsuarios (@PathVariable("idUsuario") long idUsuario) {
        return usuarioService.getUsuario(idUsuario);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDto login(@AuthenticationPrincipal UserDto usuario) {
        usuario.setToken(userAuthenticationProvider.createToken(usuario.getLogin()));
        return usuario;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody UserDto usuario) {
        usuarioService.signUp(usuario);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void signOut(@AuthenticationPrincipal UserDto usuario) {
        SecurityContextHolder.clearContext();
    }

    @PutMapping("/update/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("idUsuario") Long idUsuario, @RequestBody UserDto usuario) {
        usuarioService.update(idUsuario, usuario);
    }

    @DeleteMapping("/delete/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("idUsuario") Long idUsuario) {
        usuarioService.delete(idUsuario);
    }
}