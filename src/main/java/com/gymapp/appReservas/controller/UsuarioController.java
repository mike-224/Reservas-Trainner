package com.gymapp.appReservas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gymapp.appReservas.entity.Usuario;
import com.gymapp.appReservas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@ControllerAdvice
@RestController
@RequestMapping("${usuario.version}")
public class UsuarioController extends ResponseEntityExceptionHandler {

    @Autowired
    UsuarioRepository usuarioR;

    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        System.out.println("PIDE LISTA COMPLETA DE USUARIOS");
        return usuarioR.findAll();
    }

    @GetMapping("/usuariosDetalle/{id}")
    public Usuario detalle(@PathVariable String id){
        System.out.println("PETICION DE DETALLE DE USUARIO");
        Usuario usuario=usuarioR.findById(Long.parseLong(id)).orElse(null);
        Link link = linkTo(methodOn(UsuarioController.class).detalle(String.valueOf(id))).withSelfRel();
        usuario.add(link);
        return usuario;

    }

    @GetMapping("/clientes/error")
    public String errorService() {
        throw new RuntimeException("Un error ha sucedido");
    }
}
