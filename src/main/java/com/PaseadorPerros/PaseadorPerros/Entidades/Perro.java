package com.PaseadorPerros.PaseadorPerros.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Perro {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) //Auto_increment
    private int id_perro;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Genero_Mascota genero;

    @Column(nullable = false, length = 100)
    private String Raza;

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private int edad;

    @ManyToOne(targetEntity = Duenio.class)
    @JoinColumn(name = "Duenio")
    @JsonIgnore
    private Duenio duenio;

    @OneToMany(mappedBy = "perro",fetch = FetchType.LAZY)
    private List<PaseoPerro> paseoPerros;

    public Perro() {
    }

    public Perro(int id_perro, String nombre, Genero_Mascota genero, String raza, float peso, int edad, Duenio duenio) {
        this.id_perro = id_perro;
        this.nombre = nombre;
        this.genero = genero;
        Raza = raza;
        this.peso = peso;
        this.edad = edad;
        this.duenio = duenio;
    }

    public int getId_perro() {
        return id_perro;
    }

    public void setId_perro(int id_perro) {
        this.id_perro = id_perro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero_Mascota getGenero() {
        return genero;
    }

    public void setGenero(Genero_Mascota genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "id_perro=" + id_perro +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", Raza='" + Raza + '\'' +
                ", peso=" + peso +
                ", edad=" + edad +
                ", duenio=" + duenio +
                '}';
    }
}
