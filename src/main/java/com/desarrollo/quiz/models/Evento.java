package com.desarrollo.quiz.models;

import java.util.UUID;

public class Evento {
    private String id;
    private String nombre;
    private String fecha;
    private String hora;

    public Evento(String nombre, String fecha, String hora) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Evento(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
