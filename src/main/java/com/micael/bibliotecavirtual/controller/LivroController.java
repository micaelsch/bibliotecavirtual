package com.micael.bibliotecavirtual.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micael.bibliotecavirtual.model.Livro;
import com.micael.bibliotecavirtual.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarTodas(Authentication authentication, @RequestParam(required = false) Long categoriaId) {
        return livroService.listar(authentication.getName(), categoriaId);
    }

    @GetMapping("/{id}")
public Livro buscarPorId(@PathVariable Long id, Authentication authentication) {
    return livroService.buscarPorId(id, authentication.getName());
}

    @PostMapping
    public Livro salvar(@RequestBody Livro livro, Authentication authentication) {
        return livroService.salvar(livro, authentication.getName());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id, Authentication authentication) {
    livroService.deletar(id, authentication.getName());
}
}