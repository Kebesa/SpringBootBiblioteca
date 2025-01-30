package com.example.springntr.Controladores;

import com.example.springntr.Clases.Libro;
import com.example.springntr.Clases.Usuario;
import com.example.springntr.Repositorios.LibrosRepository;
import com.example.springntr.Repositorios.UsuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuariosControllerMOCK {
    UsuariosRepository repositorioUsuarios;

    public UsuariosControllerMOCK(){
    }

    @Autowired
    public UsuariosControllerMOCK(UsuariosRepository repositorioUsuarios){
        this.repositorioUsuarios = repositorioUsuarios;
    }

    //GET --> SELECT *
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario(){
        List<Usuario> lista = this.repositorioUsuarios.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //GET BY ISBN --> SELECT BY ISBN
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Usuario> getLibroJson(@PathVariable Integer id){
            Usuario usuario = this.repositorioUsuarios.findById(id).get();
            return ResponseEntity.ok(usuario);
    }

   //POST --> INSERT
    @PostMapping("/usuario")
    public ResponseEntity<Usuario> addLibro(@Valid @RequestBody Usuario usuario){
        System.out.println("Entra aqui");
        Usuario usuarioPersistido = this.repositorioUsuarios.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    //PUT --> UPDATE
    //falta actualizar ficheros
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@Valid @RequestBody Usuario usuario){
        Usuario usuarioPersistido = repositorioUsuarios.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id){
            repositorioUsuarios.deleteById(id);
            String mensaje = "usuario con id: "+id+" borrado";
            return ResponseEntity.ok().body(mensaje);
        }
    }


