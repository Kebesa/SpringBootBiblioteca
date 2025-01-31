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

    public boolean ValidarDNI(String dni) {
        String[] letras = dni.split("");
        String[] dni_letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        if (letras.length != 9){
            return false;
        }
        if (Character.isLetter(letras[0].charAt(0))){
            int numeros = Integer.parseInt(dni.substring(1, 8));
            if (letras[0].equals("X")) {
                if (letras[8].equals(dni_letras[numeros % 23])){
                    return true;
                } else
                    return false;
            } else if (letras[0].equals("Y")) {
                String numeros_actualizado = "1" + String.valueOf(numeros);
                if (letras[8].equals(dni_letras[Integer.parseInt(numeros_actualizado) % 23])){
                    return true;
                } else
                    return false;
            } else if (letras[0].equals("Z")) {
                String numeros_actualizado = "2" + String.valueOf(numeros);
                if (letras[8].equals(dni_letras[Integer.parseInt(numeros_actualizado) % 23])){
                    return true;
                } else
                    return false;
            } else
                return false;
        } else {
            int numeros = Integer.parseInt(dni.substring(0, 8));
            if (letras[8].equals(dni_letras[numeros % 23])) {
                return true;
            } else
                return false;
        }
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
        Usuario usuarioPersistido = null;
        if(ValidarDNI(usuario.getDni())) {
            usuarioPersistido = this.repositorioUsuarios.save(usuario);
            return ResponseEntity.ok().body(usuarioPersistido);
        } else {
            return ResponseEntity.ok().body(usuarioPersistido);
        }
    }

    //PUT --> UPDATE
    //falta actualizar ficheros
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@Valid @RequestBody Usuario usuario){
        System.out.println("Entra aqui");
        Usuario usuarioPersistido = null;
        if(ValidarDNI(usuario.getDni())) {
            usuarioPersistido = repositorioUsuarios.save(usuario);
            return ResponseEntity.ok().body(usuarioPersistido);
        } else {
            return ResponseEntity.ok().body(usuarioPersistido);
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id){
            repositorioUsuarios.deleteById(id);
            String mensaje = "usuario con id: "+id+" borrado";
            return ResponseEntity.ok().body(mensaje);
        }
    }


