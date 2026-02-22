package com.unipds.unipds.controller;

import com.unipds.unipds.exception.NotFoundException;
import com.unipds.unipds.model.Session;
import com.unipds.unipds.model.Subscription;
import com.unipds.unipds.model.User;
import com.unipds.unipds.service.ISubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private final ISubscriptionService service;

    public SubscriptionController(ISubscriptionService service) {
        this.service = service;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) {
        return ResponseEntity.status(201).body(service.addSubscription(subscription));
    }

    @GetMapping("/subscriptions/user/{id}")
    public ResponseEntity<List<Subscription>> getByUser(@PathVariable Integer id) {
        User user = new User();
        user.setUserId(id);
        return ResponseEntity.ok(service.getAllByUser(user));
    }
    @GetMapping("/subscriptions/session/{id}")
    public ResponseEntity<List<Subscription>> getBySession(@PathVariable Integer id){
        Session session = new Session();
        session.setIdSession(id);
        return ResponseEntity.ok(service.getAllBySession(session));
    }
    @DeleteMapping("subscriptions/{id}")
    public ResponseEntity<String> deleteSubById(@PathVariable Integer id){
        try {
            service.deleteSubById(id);
            return ResponseEntity.ok("Subscription successfully deleted.");
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }
    }

}