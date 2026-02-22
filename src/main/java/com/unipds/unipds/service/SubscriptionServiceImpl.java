package com.unipds.unipds.service;

import com.unipds.unipds.exception.NotFoundException;
import com.unipds.unipds.model.Session;
import com.unipds.unipds.model.Subscription;
import com.unipds.unipds.model.User;
import com.unipds.unipds.repo.SubscriptionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService{

    private final SubscriptionRepo repo;

    public SubscriptionServiceImpl(SubscriptionRepo repo) {
        this.repo = repo;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueID(UUID.randomUUID().toString());
        return repo.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return repo.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return repo.findByIdSession(session);
    }

    @Override
    public void deleteSubById(Integer id) {
        if (!repo.existsById(id)){
            throw new NotFoundException("id "+id+" not found");
        }

    }

}
