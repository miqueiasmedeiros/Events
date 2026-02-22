package com.unipds.unipds.controller;

import com.unipds.unipds.model.Conference;
import com.unipds.unipds.service.IConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceController {

    public final IConferenceService service;

    public ConferenceController(IConferenceService service) {
        this.service = service;
    }

    @PostMapping("/conferences")
    public ResponseEntity<Conference> addSession(@RequestBody Conference conference){
        return ResponseEntity.status(201).body(service.addConference(conference));
    }

    @GetMapping("/conferences")
    public ResponseEntity<List<Conference>> getAllConferences(){
        return ResponseEntity.ok(service.getAllConferences());
    }

    @GetMapping("/conferences/{id}")
    public ResponseEntity<Conference> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getConferenceById(id));
    }
}
