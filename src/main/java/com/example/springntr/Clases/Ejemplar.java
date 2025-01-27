package com.example.springntr.Clases;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ejemplar", schema = "biblioteca", catalog = "")
public class Ejemplar {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "estado", nullable = true)
    private Object estado;
    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false)
    private Libro libroByIsbn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getEstado() {
        return estado;
    }

    public void setEstado(Object estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ejemplar that = (Ejemplar) o;
        return id == that.id && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado);
    }

    public Libro getLibroByIsbn() {
        return libroByIsbn;
    }

    public void setLibroByIsbn(Libro libroByIsbn) {
        this.libroByIsbn = libroByIsbn;
    }

}
