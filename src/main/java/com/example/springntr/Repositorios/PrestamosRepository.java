package com.example.springntr.Repositorios;

import com.example.springntr.Clases.Prestamo;
import com.example.springntr.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamosRepository extends JpaRepository<Prestamo,Integer> {
}
