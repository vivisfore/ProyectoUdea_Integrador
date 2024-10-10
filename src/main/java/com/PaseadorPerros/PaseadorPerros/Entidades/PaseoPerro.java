package com.PaseadorPerros.PaseadorPerros.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//Entidad que relaciona Paseo con Perro y podemos agregar mas campos
@Entity
public class PaseoPerro {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro;*/

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Perro", referencedColumnName = "id_perro", nullable = false)
    @JsonIgnore
    private Perro perro;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Paseo", referencedColumnName = "id_paseo", nullable = false)
    @JsonIgnore
    private Paseo paseo;

    @Column(nullable = true, columnDefinition = "Varchar(255)")
    private String Observaciones;

    @Column(columnDefinition = "float default 0.0")
    private float calificacion;

}
