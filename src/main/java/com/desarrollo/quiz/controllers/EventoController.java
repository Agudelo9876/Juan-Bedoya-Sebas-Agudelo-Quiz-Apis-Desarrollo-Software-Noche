package com.desarrollo.quiz.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.quiz.models.Evento;
import com.desarrollo.quiz.models.Persona;
import com.desarrollo.quiz.services.IEventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    private final IEventoService eventoService;

    @Autowired
    public EventoController(IEventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping("/{idEvento}/inscribir")
    public ResponseEntity<Persona> saveParticipante(@PathVariable String idEvento, @RequestBody Persona participante) {
        Persona participanteSave = eventoService.saveParticipante(idEvento, participante);
        return new ResponseEntity<>(participanteSave, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<Evento>> getAllEventos(String fecha) {
        List<Evento> participantes = eventoService.getAllEventos();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    @GetMapping("/participantes/{idEvento}")
    public ResponseEntity<List<Persona>> getParticipantes(@PathVariable String idEvento) {
        List<Persona> participantes = eventoService.getAllParticipantesById(idEvento);
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getEventosByFecha(@RequestParam(required = false) String fecha) {
        List<Evento> eventos = eventoService.getEventoByFecha(fecha);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @DeleteMapping("{idEvento}/inscripcion/{personaId}")
    public ResponseEntity<Void> delete(@RequestHeader("Authorization") String authToken, @PathVariable String idEvento, @PathVariable String personaId){
        Persona persona = eventoService.findByAuthToken(authToken);

        if (persona != null) {
            eventoService.deleteById(idEvento, personaId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}
