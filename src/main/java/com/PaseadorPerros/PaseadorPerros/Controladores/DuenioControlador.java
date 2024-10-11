package com.PaseadorPerros.PaseadorPerros.Controladores;

import com.PaseadorPerros.PaseadorPerros.Entidades.Duenio;
import com.PaseadorPerros.PaseadorPerros.Servicios.DuenioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/duenios")
public class DuenioControlador {

    @Autowired
    private DuenioServicio duenioService;

    // Create or update a Duenio
    @PostMapping
    public ResponseEntity<Duenio> createDuenio(@RequestBody Duenio duenio) {
        Duenio savedDuenio = duenioService.saveDuenio(duenio);
        return new ResponseEntity<>(savedDuenio, HttpStatus.CREATED);
    }

    // Get a Duenio by documento
    @GetMapping("/{documento}")
    public ResponseEntity<Duenio> getDuenioById(@PathVariable String documento) {
        Optional<Duenio> duenio = duenioService.getDuenioById(documento);
        return duenio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Duenios
    @GetMapping
    public ResponseEntity<List<Duenio>> getAllDuenios() {
        List<Duenio> duenios = duenioService.getAllDuenios();
        return new ResponseEntity<>(duenios, HttpStatus.OK);
    }

    // Delete a Duenio by documento
    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> deleteDuenio(@PathVariable String documento) {
        duenioService.deleteDuenio(documento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{documento}")
    public ResponseEntity<Duenio> updateDuenio(@PathVariable String documento, @RequestBody Duenio duenio) {
        Duenio partialUpdateDuenio = new Duenio();
        if (duenio.getNombre() != null) {
            partialUpdateDuenio.setNombre(duenio.getNombre());
        }
        if (duenio.getApellido() != null) {
            partialUpdateDuenio.setApellido(duenio.getApellido());
        }
        if (duenio.getTelefono() != null) {
            partialUpdateDuenio.setTelefono(duenio.getTelefono());
        }
        if (duenio.getDireccion() != null) {
            partialUpdateDuenio.setDireccion(duenio.getDireccion());
        }
        if (duenio.getCiudad() != null) {
            partialUpdateDuenio.setCiudad(duenio.getCiudad());
        }
        if (duenio.getGenero() != null) {
            partialUpdateDuenio.setGenero(duenio.getGenero());
        }
        if (duenio.getEmail() != null) {
            partialUpdateDuenio.setEmail(duenio.getEmail());
        }
        Duenio updatedDuenio = duenioService.updateDuenioById(documento, partialUpdateDuenio);
        return new ResponseEntity<>(updatedDuenio, HttpStatus.OK);
    }
}
