package com.desarrollo.quiz.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.desarrollo.quiz.models.Evento;
import com.desarrollo.quiz.models.Persona;

@Repository
public class EventoRepository {

    //base de datos para eventos
    private final Map<String, Evento> db = new HashMap<>();

    //base de datos para participantes
    private final Map<String, List<Persona>> participantes= new HashMap<>();

    //base de datos para tokens
    private final Map<String, String> tokens = new HashMap<>();

    public Evento saveEvento(Evento evento) { 

        db.put(evento.getId(), evento);
        participantes.put(evento.getId(), new ArrayList<>());
        return evento;

    }

    public List<Evento> findEventoByFecha(String fecha){
        return db.values().stream()
        .filter(u -> fecha == null || u.getFecha().contains(fecha))
        .collect(Collectors.toList());
    }

    public List<Evento> getAllEventos(){
        return new ArrayList<>(db.values());
    }

    public Persona saveParticipante(String idEvento, Persona persona) {
        participantes.get(idEvento).add(persona);
        return persona;
    }

    public List<Persona> getParticipantesById(String idEvento) {
        return participantes.getOrDefault(idEvento, new ArrayList<>());
    }

}