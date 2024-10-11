package com.PaseadorPerros.PaseadorPerros.Servicios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PaseoRepositorio;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PerroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerroServicio {

    @Autowired
    private PerroRepositorio perroRepositorio;

    @Autowired
    private PaseoRepositorio paseoRepositorio;

    public List<Perro> getAllPerros() {
        return perroRepositorio.findAll();
    }

    public List<Perro> getAllPerrosWithDuenios() {
        return perroRepositorio.findAllWithDuenios();
    }

    public Perro crearPerro(Perro perro) {
        return perroRepositorio.save(perro);
    }
}
