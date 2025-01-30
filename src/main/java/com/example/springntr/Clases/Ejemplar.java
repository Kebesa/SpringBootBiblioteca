package com.example.springntr.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ejemplar", schema = "biblioteca", catalog = "")
public class Ejemplar {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotEmpty(message = "Error en el id, ingresa un valor que no esté vacío.")
    @NotNull(message = "Error en el id, ingresa un valor que no sea nulo.")
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @NotEmpty(message = "Error en el estado, ingresa un valor que no esté vacío.")
    @Pattern(regexp = "^(Prestado|Disponible|Dañado)$", message = "El estado solo puede ser: Disponible, Prestado o Dañado (con la primera letra mayúscula).")
    @NotNull(message = "Error en el estado, ingresa un valor que no sea nulo.")
    @Column(name = "estado", nullable = true)
    private String estado;
    @ManyToOne
    @NotEmpty(message = "Error en el libro, ingresa un valor que no esté vacío.")
    @NotNull(message = "Error en el libro, ingresa un valor que no sea nulo.")
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false)
    private Libro libroByIsbn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
