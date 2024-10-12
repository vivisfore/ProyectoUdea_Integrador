package com.PaseadorPerros.PaseadorPerros.Controladores;

import com.PaseadorPerros.PaseadorPerros.DTO.PerroRequest;
import com.PaseadorPerros.PaseadorPerros.Entidades.Duenio;
import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;
import com.PaseadorPerros.PaseadorPerros.Repositorios.PerroRepositorio;
import com.PaseadorPerros.PaseadorPerros.Servicios.DuenioServicio;
import com.PaseadorPerros.PaseadorPerros.Servicios.PaseoServicio;
import com.PaseadorPerros.PaseadorPerros.Servicios.PerroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perros")
public class PerroControlador {

    @Autowired
    private PerroServicio perroServicio;

    @Autowired
    private DuenioServicio duenioServicio;

    @Autowired
    private PerroRepositorio perroRepositorio;

    @GetMapping
    public List<Perro> getAllPerros() {
        return perroServicio.getAllPerros();
    }

    @GetMapping("/paseador")
    public List<Perro> getAllPerrosWithPaseador() {
        return perroServicio.getAllPerrosWithDuenios();
    }

    @PostMapping
    public Perro crearPerro(@RequestBody PerroRequest perro){
        String duenioId = perro.getDuenioId();
        Optional<Duenio> duenio = duenioServicio.getDuenioById(duenioId);
        Perro createPerro = perro.getPerro();
        return perroServicio.crearPerro(createPerro, duenio);
    }

    @GetMapping("/nombre/{nombre}")
    public Perro getPerroByNombre(@PathVariable String nombre) {
        return perroRepositorio.findByNombre(nombre);
    }

    @GetMapping("/raza/{raza}")
    public List<Perro> getPerroByRaza(@PathVariable String raza) {
        return perroRepositorio.findByRaza(raza);
    }
}
