package com.PaseadorPerros.PaseadorPerros.Servicios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Duenio;
import com.PaseadorPerros.PaseadorPerros.Entidades.Paseador;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PaseadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaseadorServicio {

    @Autowired
    private PaseadorRepositorio paseadorRepositorio;

    public Paseador savePaseador(Paseador paseador) {
        return paseadorRepositorio.save(paseador);
    }

    public void deletePaseadoById(String documento) {
        paseadorRepositorio.deleteById(documento);
    }

    public Optional<Paseador> getPaseadorById(String documento) {
        return paseadorRepositorio.findById(documento);
    }
}
