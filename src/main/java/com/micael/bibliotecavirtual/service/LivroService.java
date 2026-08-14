package com.micael.bibliotecavirtual.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Livro buscarPorId(Long id, String email) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        if (!livro.getUsuario().getEmail().equals(email)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Esse livro não pertence a você");
        }

        return livro;
    }

    public Livro salvar(Livro livro, String emailUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        livro.setUsuario(usuario);
        return livroRepository.save(livro);
    }

    public void deletar(Long id, String email) {
        buscarPorId(id, email);
        livroRepository.deleteById(id);
    }
}
