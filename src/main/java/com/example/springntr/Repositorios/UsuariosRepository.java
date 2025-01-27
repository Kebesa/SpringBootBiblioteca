package com.example.springntr.Repositorios;

import com.example.springntr.Clases.Libro;
import com.example.springntr.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {
}
