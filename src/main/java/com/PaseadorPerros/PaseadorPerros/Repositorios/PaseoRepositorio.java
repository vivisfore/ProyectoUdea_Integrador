package com.PaseadorPerros.PaseadorPerros.Repositorios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Paseo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseoRepositorio extends JpaRepository<Paseo, Integer> {
}

