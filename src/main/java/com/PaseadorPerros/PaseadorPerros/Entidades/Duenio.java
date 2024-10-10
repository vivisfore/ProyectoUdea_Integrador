package com.PaseadorPerros.PaseadorPerros.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Dueño")
public class Duenio {

    @Id
    private String documento;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(targetEntity = Perro.class,fetch = FetchType.LAZY, mappedBy = "duenio")
    private List<Perro> perro;

    public Duenio() {
    }

    public Duenio(String documento, String nombre, String apellido, String telefono, String direccion, Ciudad ciudad, Genero genero, String email) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.genero = genero;
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Duenio{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", genero='" + genero + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
