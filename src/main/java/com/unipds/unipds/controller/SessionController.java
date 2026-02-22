package com.unipds.unipds.controller;

import com.unipds.unipds.model.Session;
import com.unipds.unipds.service.ISessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

    private final ISessionService service;

    private SessionController(ISessionService service){
        this.service = service;
    }
    @PostMapping("/sessions")
    public ResponseEntity<Session> addSession(@RequestBody Session session){
        return ResponseEntity.status(201).body(service.addSession(session));
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<Session>> getAllSessions(){
        return ResponseEntity.ok(service.getAllSessions());
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<Session> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getSessionById(id));
    }
}
