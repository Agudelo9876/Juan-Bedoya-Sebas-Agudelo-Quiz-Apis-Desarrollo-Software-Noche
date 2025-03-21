package com.desarrollo.quiz.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desarrollo.quiz.models.Evento;
import com.desarrollo.quiz.models.Persona;
import com.desarrollo.quiz.repositories.EventoRepository;

@Service
public class EventoService implements IEventoService {
    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;

        initSampleData();
    }

    private void initSampleData() {
        Evento evento1 = new Evento("Fiesta en dubai", "02-12-2024", "3:30 PM");
        Evento evento2 = new Evento("Reunión de software", "12-12-2028", "3:30 PM");
        Evento evento3 = new Evento("Partido nacional de futbol", "23-11-2024", "3:30 PM");

        save(evento1);
        save(evento2);
        save(evento3);
    }

    public Evento save(Evento evento) {
        return eventoRepository.saveEvento(evento);
    }

    public Persona saveParticipante(String idEvento, Persona persona) {
        return eventoRepository.saveParticipante(idEvento, persona);
    }

    public List<Evento> getAllEventos() {
        return eventoRepository.getAllEventos();
    }

    public List<Persona> getAllParticipantesById(String idEvento) {
        return eventoRepository.getParticipantesById(idEvento);
    }

    public List<Evento> getEventoByFecha(String fecha) {
        return eventoRepository.findEventoByFecha(fecha);
    }

    public void deleteById(String idEvento, String idPersona) {
        eventoRepository.deleteById(idEvento, idPersona);
    }

    public Persona findByAuthToken(String token){
        return eventoRepository.findByAuthToken(token);
    }
}
