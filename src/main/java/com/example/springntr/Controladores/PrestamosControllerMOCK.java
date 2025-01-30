package com.example.springntr.Controladores;

import com.example.springntr.Clases.Prestamo;
import com.example.springntr.Repositorios.PrestamosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/prestamos")

public class PrestamosControllerMOCK {
    PrestamosRepository repositorioPrestamos;

    public PrestamosControllerMOCK(){
    }

    @Autowired
    public PrestamosControllerMOCK(PrestamosRepository repositorioPrestamos){
        this.repositorioPrestamos = repositorioPrestamos;
    }

    //GET --> SELECT *
    @GetMapping
    public ResponseEntity<List<Prestamo>> getPrestamo(){
        List<Prestamo> lista = this.repositorioPrestamos.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //GET BY ISBN --> SELECT BY ISBN
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Prestamo> getPrestamoJson(@PathVariable Integer id){
            Prestamo p = this.repositorioPrestamos.findById(id).get();
            return ResponseEntity.ok(p);
    }

   //POST --> INSERT
    @PostMapping("/prestamo")
    public ResponseEntity<Prestamo> addPrestamo(@Valid @RequestBody Prestamo prestamo){
        System.out.println("Entra aqui");
        Prestamo prestamoPersistido = this.repositorioPrestamos.save(prestamo);
        return ResponseEntity.ok().body(prestamoPersistido);
    }

    //PUT --> UPDATE
    //falta actualizar ficheros
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@Valid @RequestBody Prestamo prestamo){
        Prestamo prestamoPersistido = repositorioPrestamos.save(prestamo);
        return ResponseEntity.ok().body(prestamoPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrestamo(@PathVariable Integer id){
            repositorioPrestamos.deleteById(id);
            String mensaje = "prestamo con id: "+id+" borrado";
            return ResponseEntity.ok().body(mensaje);
        }
    }


