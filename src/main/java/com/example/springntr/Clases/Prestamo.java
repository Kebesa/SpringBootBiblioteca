package com.example.springntr.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "prestamo", schema = "biblioteca", catalog = "")
public class Prestamo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Error en el id, ingresa un valor que no sea nulo")
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @NotNull(message = "Error en la fecha de inicio, ingresa un valor que no sea nulo")
    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    @Basic
    @NotNull(message = "Error en la fecha de devolución, ingresa un valor que no sea nulo")
    @Column(name = "fechaDevolucion", nullable = true)
    private Date fechaDevolucion;
    @ManyToOne
    @NotNull(message = "Error en el usuario, ingresa un valor que no sea nulo")
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuarioByUsuarioId;
    @ManyToOne
    @NotNull(message = "Error en el ejemplar, ingresa un valor que no sea nulo")
    @JoinColumn(name = "ejemplar_id", referencedColumnName = "id", nullable = false)
    private Ejemplar ejemplarByEjemplarId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo that = (Prestamo) o;
        return id == that.id && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaDevolucion, that.fechaDevolucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInicio, fechaDevolucion);
    }

    public Usuario getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(Usuario usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }

    public Ejemplar getEjemplarByEjemplarId() {
        return ejemplarByEjemplarId;
    }

    public void setEjemplarByEjemplarId(Ejemplar ejemplarByEjemplarId) {
        this.ejemplarByEjemplarId = ejemplarByEjemplarId;
    }
}
