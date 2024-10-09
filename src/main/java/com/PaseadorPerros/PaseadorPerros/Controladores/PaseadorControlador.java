package com.PaseadorPerros.PaseadorPerros.Controladores;

import com.PaseadorPerros.PaseadorPerros.Entidades.Paseador;
import com.PaseadorPerros.PaseadorPerros.Servicios.PaseadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/paseador")
public class PaseadorControlador {

    @Autowired
    private PaseadorServicio paseadorServicio;

    @PostMapping
    public ResponseEntity<Paseador> crearPaseador(@RequestBody Paseador paseador) {
        String apellido = paseador.getApellido();
        String nombre = paseador.getNombre();

        String nuevoApellido = apellido.toUpperCase();
        String nuevoNombre = nombre.toUpperCase();

        paseador.setNombre(nuevoNombre);
        paseador.setApellido(nuevoApellido);

        Paseador paseadorCreado = paseadorServicio.savePaseador(paseador);

        return new ResponseEntity<>(paseadorCreado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> deletePaseadorById(@PathVariable String documento) {
        paseadorServicio.deletePaseadoById(documento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<Paseador> getPaseadorById(@PathVariable String documento) {
        Optional<Paseador> paseador = paseadorServicio.getPaseadorById(documento);
        return paseador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
