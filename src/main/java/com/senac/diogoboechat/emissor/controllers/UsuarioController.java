package com.senac.diogoboechat.emissor.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.diogoboechat.emissor.entities.Usuario;
import com.senac.diogoboechat.emissor.services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "adicionarUsuario")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
        Usuario tempUsuario = usuarioService.adicionarUsuario(usuario);
        return ResponseEntity.ok(tempUsuario);
    }

}