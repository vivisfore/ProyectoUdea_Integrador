package com.PaseadorPerros.PaseadorPerros.Repositorios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Paseador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaseadorRepositorio extends JpaRepository<Paseador, String> {
}
