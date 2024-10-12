package com.PaseadorPerros.PaseadorPerros.DTO;

import com.PaseadorPerros.PaseadorPerros.Entidades.Perro;

public class PerroRequest {
    private String duenioId;
    private Perro perro;

    public String getDuenioId() {
        return duenioId;
    }

    public void setDuenioId(String duenioId) {
        this.duenioId = duenioId;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }
}
