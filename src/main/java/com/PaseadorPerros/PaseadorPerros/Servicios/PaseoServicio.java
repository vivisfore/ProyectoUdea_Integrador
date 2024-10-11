package com.PaseadorPerros.PaseadorPerros.Servicios;

import com.PaseadorPerros.PaseadorPerros.DTO.PaseoRequest;
import com.PaseadorPerros.PaseadorPerros.Entidades.Paseador;
import com.PaseadorPerros.PaseadorPerros.Entidades.Paseo;
import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PaseadorRepositorio;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PaseoRepositorio;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PerroRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaseoServicio {

    @Autowired
    private PaseoRepositorio paseoRepository;

    @Autowired
    private PerroRepositorio perroRepository;

    @Autowired
    private PaseadorRepositorio paseadorRepositorio;

    public Paseo createPaseo(PaseoRequest paseoRequest) {
        Paseo paseo = paseoRequest.getPaseo();
        Paseador paseador = paseadorRepositorio.findById(paseoRequest.getPaseadorId()).orElseThrow(() -> new RuntimeException("Paseador not found"));;

        List<Perro> perros = perroRepository.findAllById(paseoRequest.getPerroIds());

        paseo.setPerro(perros);
        paseo.setPaseador(paseador);

        return paseoRepository.save(paseo);
    }

    public List<Paseo> getAllPaseos() {
        return paseoRepository.findAll();
    }
}

