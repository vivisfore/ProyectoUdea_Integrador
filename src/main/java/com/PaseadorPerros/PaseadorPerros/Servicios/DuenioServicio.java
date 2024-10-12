package com.PaseadorPerros.PaseadorPerros.Servicios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Duenio;
import com.PaseadorPerros.PaseadorPerros.Repositorios.DuenioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioServicio{

    @Autowired
    private DuenioRepositorio duenioRepository;

    // Insert or update a Duenio
    public Duenio saveDuenio(Duenio duenio) {
        return duenioRepository.save(duenio);
    }

    // Get a Duenio by documento
    public Optional<Duenio> getDuenioById(String documento) {
        return duenioRepository.findById(documento);
    }

    // Get all Duenios
    public List<Duenio> getAllDuenios() {
        return duenioRepository.findAll();
    }

    // Delete a Duenio by documento
    public void deleteDuenio(String documento) {
        duenioRepository.deleteById(documento);
    }

    // Method to update a Duenio by ID
    public Duenio updateDuenioById(String documento, Duenio updatedDuenio) {
        // Check if the Duenio exists
        return duenioRepository.findById(documento).map(existingDuenio -> {
            // Update fields
            if (updatedDuenio.getNombre() != null) {
                existingDuenio.setNombre(updatedDuenio.getNombre());
            }
            if (updatedDuenio.getApellido() != null) {
                existingDuenio.setApellido(updatedDuenio.getApellido());
            }
            if (updatedDuenio.getTelefono() != null) {
                existingDuenio.setTelefono(updatedDuenio.getTelefono());
            }
            if (updatedDuenio.getDireccion() != null) {
                existingDuenio.setDireccion(updatedDuenio.getDireccion());
            }
            if (updatedDuenio.getCiudad() != null) {
                existingDuenio.setCiudad(updatedDuenio.getCiudad());
            }
            if (updatedDuenio.getGenero() != null) {
                existingDuenio.setGenero(updatedDuenio.getGenero());
            }
            if (updatedDuenio.getEmail() != null) {
                existingDuenio.setEmail(updatedDuenio.getEmail());
            }

            // Save the updated Duenio
            return duenioRepository.save(existingDuenio);
        }).orElseThrow(() -> new RuntimeException("Duenio with ID " + documento + " not found"));
    }
}
