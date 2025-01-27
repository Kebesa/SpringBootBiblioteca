package com.example.springntr.Controladores;

import com.example.springntr.Clases.Ejemplar;
import com.example.springntr.Clases.Libro;
import com.example.springntr.Repositorios.EjemplaresRepository;
import com.example.springntr.Repositorios.LibrosRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/ejemplares")

public class EjemplaresControllerMOCK {
    EjemplaresRepository repositorioEjemplares;

    public EjemplaresControllerMOCK(){
    }

    @Autowired
    public EjemplaresControllerMOCK(EjemplaresRepository repositorioEjemplares){
        this.repositorioEjemplares = repositorioEjemplares;
    }

    //GET --> SELECT *
    @GetMapping
    public ResponseEntity<List<Ejemplar>> getLibro(){
        List<Ejemplar> lista = this.repositorioEjemplares.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //GET BY ISBN --> SELECT BY ISBN
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Ejemplar> getEjemlarJson(@PathVariable Integer id){
            Ejemplar e = this.repositorioEjemplares.findById(id).get();
            return ResponseEntity.ok(e);
    }

   //POST --> INSERT
    @PostMapping("/ejemplar")
    public ResponseEntity<Ejemplar> addEjemplar(@Valid @RequestBody Ejemplar ejemplar){
        System.out.println("Entra aqui");
        Ejemplar ejemplarPersistido = this.repositorioEjemplares.save(ejemplar);
        return ResponseEntity.ok().body(ejemplarPersistido);
    }

    //PUT --> UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> updateEjemplar(@RequestBody Ejemplar ejemplar){
        Ejemplar ejemplarPersistido = repositorioEjemplares.save(ejemplar);
        return ResponseEntity.ok().body(ejemplarPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEjemplar(@PathVariable Integer id){
            repositorioEjemplares.deleteById(id);
            String mensaje = "ejemplar con id: "+id+" borrado";
            return ResponseEntity.ok().body(mensaje);
        }
    }


