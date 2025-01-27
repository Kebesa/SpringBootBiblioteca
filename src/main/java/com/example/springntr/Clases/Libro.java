package com.example.springntr.Clases;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "libro", schema = "biblioteca", catalog = "")
public class Libro {
    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;
    @Basic
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;
    @Basic
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
