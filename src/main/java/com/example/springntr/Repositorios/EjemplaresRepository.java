package com.example.springntr.Repositorios;

import com.example.springntr.Clases.Ejemplar;
import com.example.springntr.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjemplaresRepository extends JpaRepository<Ejemplar,Integer> {
}
