package com.PaseadorPerros.PaseadorPerros.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Paseo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paseo;

    //@DateTimeFormat
    //@Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(columnDefinition = "TIME", nullable = false)
    private LocalTime hora_inicio;

    @Column(columnDefinition = "TIME", nullable = true)
    private LocalTime hora_fin;

    private float distancia;
    private String ruta;

    @Column(columnDefinition = "float default 20000.0")
    private float valor;

    @ManyToOne(targetEntity = Paseador.class)
    @JoinColumn(name = "paseador")
    private Paseador paseador;

    //Relacion Paseo-Perro---> Genera tabla resultante de la relacion unicamente con llaves foraneas
    @ManyToMany(targetEntity = Perro.class, fetch = FetchType.LAZY)
    @JoinTable(name = "RegistroPaseo",
            joinColumns = @JoinColumn(name = "id_paseo"),
            inverseJoinColumns = @JoinColumn(name = "id_perro"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_paseo","id_perro"})
    )
    //--------------------------------------------------------------------------------------------
    private List<Perro> perro;

    @OneToMany(mappedBy = "paseo",fetch = FetchType.LAZY)
    private List<PaseoPerro> paseoPerros;

    public Paseo(int id_paseo, LocalDate fecha, LocalTime hora_inicio, LocalTime hora_fin, float distancia, String ruta, float valor, Paseador paseador, List<Perro> perro) {
        this.id_paseo = id_paseo;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.distancia = distancia;
        this.ruta = ruta;
        this.valor = valor;
        this.paseador = paseador;
        this.perro = perro;
    }

    public Paseo() {
    }

    public int getId_paseo() {
        return id_paseo;
    }

    public void setId_paseo(int id_paseo) {
        this.id_paseo = id_paseo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Paseador getPaseador() {
        return paseador;
    }

    public void setPaseador(Paseador paseador) {
        this.paseador = paseador;
    }

    public List<Perro> getPerro() {
        return perro;
    }

    public void setPerro(List<Perro> perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {
        return "Paseo{" +
                "id_paseo=" + id_paseo +
                ", fecha=" + fecha +
                ", hora_inicio=" + hora_inicio +
                ", hora_fin=" + hora_fin +
                ", distancia=" + distancia +
                ", ruta='" + ruta + '\'' +
                ", valor=" + valor +
                ", paseador=" + paseador +
                ", perro=" + perro +
                '}';
    }
}
