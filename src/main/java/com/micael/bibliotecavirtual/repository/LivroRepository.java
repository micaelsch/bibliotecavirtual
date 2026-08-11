package com.micael.bibliotecavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.micael.bibliotecavirtual.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
