package com.micael.bibliotecavirtual.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.micael.bibliotecavirtual.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByUsuarioEmail(String email);
    List<Livro> findByUsuarioEmailAndCategoriaId(String email, Long categoriaId);
}
