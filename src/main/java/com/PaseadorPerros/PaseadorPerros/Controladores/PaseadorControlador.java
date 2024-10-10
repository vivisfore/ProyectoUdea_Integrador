package com.PaseadorPerros.PaseadorPerros.Controladores;

import com.PaseadorPerros.PaseadorPerros.Entidades.Paseador;
import com.PaseadorPerros.PaseadorPerros.Servicios.PaseadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Paseador")
public class PaseadorControlador {

    @Autowired
    private PaseadorServicio paseadorServicio;

    @PostMapping
    public ResponseEntity<Paseador> crearPaseador(@RequestBody Paseador paseador){
        Paseador paseadorCreado=paseadorServicio.savePaseador(paseador);
        return  new ResponseEntity<>(paseadorCreado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Paseador> todos(){
        return paseadorServicio.getAll();
    }

    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> deletePaseadorById(@PathVariable String documento){
        paseadorServicio.deletePaseadorById(documento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{documento}")
    public Optional<Paseador> getPaseadorById(@PathVariable String documento){
        return paseadorServicio.getPaseadorById(documento);
    }
}
