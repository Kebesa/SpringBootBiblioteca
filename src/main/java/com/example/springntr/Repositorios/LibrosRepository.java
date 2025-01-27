package com.example.springntr.Repositorios;

import com.example.springntr.Clases.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro,String> {
}
