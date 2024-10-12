package com.PaseadorPerros.PaseadorPerros.Repositorios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerroRepositorio extends JpaRepository<Perro, Integer> {
    @Query("SELECT p FROM Perro p JOIN FETCH p.duenio")
    List<Perro> findAllWithDuenios();

    Perro findByNombre(String nombre);

    List<Perro> findByRaza(String raza);
}
