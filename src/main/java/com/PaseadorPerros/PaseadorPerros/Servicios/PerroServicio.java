package com.PaseadorPerros.PaseadorPerros.Servicios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Duenio;
import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PaseoRepositorio;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PerroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Perro crearPerro(Perro perro, Optional<Duenio> duenio) {
        duenio.ifPresent(perro::setDuenio);
        return perroRepositorio.save(perro);
    }
}
