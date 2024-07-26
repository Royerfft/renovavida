package com.example.appkio;

public enum TipodeArbol {
    ENCINA("Encina"),
    TAMARIZ("Tamariz"),
    ALAMO_BLANCO("Alamo_Blanco"),
    ENERBO("Enerbo"),
    PINO_RESINERO("Pino_Resinero");

    private String nombre;

    TipodeArbol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
