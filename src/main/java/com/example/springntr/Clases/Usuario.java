package com.example.springntr.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario", schema = "biblioteca", catalog = "")
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @NotEmpty(message = "Error en el DNI o NIE, ingresa un valor que no esté vacío.")
    @Pattern(regexp = "^(\\d{8}[A-HJ-NP-TV-Z]|[XYZ]\\d{7}[A-HJ-NP-TV-Z])$", message = "Error en el DNI o NIE, ingresa un DNI o NIE que tenga un patrón correcto.")
    @NotNull(message = "Error en el DNI o NIE, ingresa un valor que no sea nulo.")
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;
    @Basic
    @Size(max = 100, message = "Error en el nombre, ingresa un valor que no tenga más de 100 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9ÁÉÍÓÚáéíóúÑñ ]+$" , message = "Error en el nombre, ingresa un título que solo tenga letras y números.")
    @NotNull(message = "Error en el nombre, ingresa un valor que no sea nulo.")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @NotEmpty(message = "Error en el email, ingresa un valor que no esté vacío.")
    @Pattern(regexp = "([A-Za-z0-9]{1,50}@gmail.com)", message = "Error en el email, ingresa un email que sea del proveedor de Gmail.")
    @NotNull(message = "Error en el email, ingresa un valor que no sea nulo.")
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @NotEmpty(message = "Error en la contraseña, ingresa un valor que no esté vacío.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,8}+$", message = "Error en la contraseña, ingresa una contraseña que tenga de 4 a 12 caracteres que tenga letras y números.")
    @NotNull(message = "Error en la contraseña, ingresa un valor que no sea nulo.")
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @NotEmpty(message = "Error en el tipo de usuario, ingresa un valor que no esté vacío.")
    @Pattern(regexp = "^(normal|administrador)$", message = "El usuario solo puede ser: normal o administrador (todo en minúsculas).")
    @NotNull(message = "Error en el tipo de usuario, ingresa un valor que no sea nulo.")
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Basic
    @Column(name = "penalizacionHasta", nullable = true)
    private Date penalizacionHasta;

    public Usuario(String dni, String nombre, String email, String password, String tipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        if (tipo.equals("administrador") || tipo.equals("normal"))
            this.tipo = tipo;
        else
            throw new RuntimeException("El usuario solo puede ser administrador o normal");
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(Date penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario that = (Usuario) o;
        return id == that.id && Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(tipo, that.tipo) && Objects.equals(penalizacionHasta, that.penalizacionHasta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, email, password, tipo, penalizacionHasta);
    }
}
