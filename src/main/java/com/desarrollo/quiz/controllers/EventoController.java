package com.desarrollo.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/{id}/inscribir")
    public ResponseEntity<Persona> saveParticipante(@PathVariable String idEvento, @RequestBody Persona participante) {
        Persona participanteSave = eventoService.saveParticipante(idEvento, participante);
        return new ResponseEntity<>(participanteSave, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> participantes = eventoService.getAllEventos();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }
}
