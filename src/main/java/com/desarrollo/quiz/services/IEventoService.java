package com.desarrollo.quiz.services;

import java.util.List;
import com.desarrollo.quiz.models.Evento;
import com.desarrollo.quiz.models.Persona;

public interface IEventoService {
    Persona saveParticipante(String idEvento, Persona persona);
    List<Evento> getAllEventos();
    List<Evento> getEventoByFecha(String fecha);
    List<Persona> getAllParticipantesById(String idEvento);
    void deleteById(String idEvento, String idPersona);
    Persona findByAuthToken(String token);
}
