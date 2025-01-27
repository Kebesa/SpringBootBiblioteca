package com.example.springntr.Clases;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "prestamo", schema = "biblioteca", catalog = "")
public class Prestamo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    @Basic
    @Column(name = "fechaDevolucion", nullable = true)
    private Date fechaDevolucion;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuarioByUsuarioId;
    @ManyToOne
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
