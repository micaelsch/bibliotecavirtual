package com.micael.bibliotecavirtual.service;

import java.util.List;
import java.util.Optional;  
import org.springframework.stereotype.Service;
import com.micael.bibliotecavirtual.model.Livro;
import com.micael.bibliotecavirtual.repository.LivroRepository;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodas() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
    
}
