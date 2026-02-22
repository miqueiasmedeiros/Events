package com.unipds.unipds.controller;

import com.unipds.unipds.exception.NotFoundException;
import com.unipds.unipds.model.Conference;
import com.unipds.unipds.model.User;
import com.unipds.unipds.service.IConferenceService;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @PutMapping("/conferences/{id}")
    public ResponseEntity<Conference> updateConferenceById(@RequestBody Conference conference, @PathVariable Integer id){
        Conference update = service.updateConferenceById(conference, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/conferences/{id}")
    public ResponseEntity<String> deleteConferenceById(@PathVariable Integer id){
        try {
            service.deleteConferenceById(id);
            return ResponseEntity.ok("Conference sucessfully deleted!");
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }
    }
}
