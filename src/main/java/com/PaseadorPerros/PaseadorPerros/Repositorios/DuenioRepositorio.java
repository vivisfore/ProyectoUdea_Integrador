package com.PaseadorPerros.PaseadorPerros.Repositorios;

import com.PaseadorPerros.PaseadorPerros.Entidades.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenioRepositorio extends JpaRepository<Duenio, String> {
    // You can define custom queries here if needed
}

