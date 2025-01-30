package com.example.springntr.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "libro", schema = "biblioteca", catalog = "")
public class Libro {
    @Id
    @NotEmpty(message = "Error en el ISBN, ingresa un valor que no esté vacío.")
    @Pattern(regexp = "^97[89]-\\d-\\d{2,5}-\\d{2,7}-\\d", message = "Error en el ISBN, ingresa un valor con el patrón del siguiente ejemplo: ISBN-13: 978-0-596-52068-7.")
    @NotNull(message = "Error en el ISBN, ingresa un valor que no sea nulo.")
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;
    @Basic
    @NotEmpty(message = "Error en el título, ingresa un valor que no esté vacío.")
    @Size(max = 100, message = "Error en el título, ingresa un valor que no tenga más de 100 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Error en el título, ingresa un título que solo tenga letras y números.")
    @NotNull(message = "Error en el título, ingresa un valor que no sea nulo.")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;
    @Basic
    @NotEmpty(message = "Error en el autor, ingresa un valor que no esté vacío.")
    @Size(max = 100, message = "Error en el autor, ingresa un valor que no tenga más de 100 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Error en el autor, ingresa un autor que solo tenga letras y números.")
    @NotNull(message = "Error en el autor, ingresa un valor que no sea nulo.")
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro that = (Libro) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titulo, autor);
    }
}
