package com.PaseadorPerros.PaseadorPerros.Controladores;

import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;
import com.PaseadorPerros.PaseadorPerros.Servicios.PerroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perros")
public class PerroControlador {

    @Autowired
    private PerroServicio perroServicio;

    @GetMapping
    public List<Perro> getAllPerros() {
        return perroServicio.getAllPerros();
    }

    @GetMapping("/paseador")
    public List<Perro> getAllPerrosWithPaseador() {
        return perroServicio.getAllPerrosWithDuenios();
    }

    @PostMapping
    public Perro crearPerro(@RequestBody Perro perro){
        return perroServicio.crearPerro(perro);
    }
}
