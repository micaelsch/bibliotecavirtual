package com.micael.bibliotecavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.micael.bibliotecavirtual.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByEmail(String email);
}
