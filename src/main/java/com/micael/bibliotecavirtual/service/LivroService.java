package com.micael.bibliotecavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.micael.bibliotecavirtual.model.Livro;
import com.micael.bibliotecavirtual.model.Usuario;
import com.micael.bibliotecavirtual.repository.LivroRepository;
import com.micael.bibliotecavirtual.repository.UsuarioRepository;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public LivroService(LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Livro> listar(String email, Long categoriaId) {
        if (categoriaId == null) {
            return livroRepository.findByUsuarioEmail(email);
        }
        return livroRepository.findByUsuarioEmailAndCategoriaId(email, categoriaId);
    }

    public Livro buscarPorId(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }

    public Livro salvar(Livro livro, String emailUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        livro.setUsuario(usuario);
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
