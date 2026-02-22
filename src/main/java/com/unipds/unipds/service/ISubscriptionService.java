package com.unipds.unipds.service;

import com.unipds.unipds.model.Session;
import com.unipds.unipds.model.Subscription;
import com.unipds.unipds.model.User;

import java.util.List;

public interface ISubscriptionService {

    public Subscription addSubscription(Subscription subscription);
    public List<Subscription> getAllByUser(User user);
    public List<Subscription> getAllBySession(Session session);
    public void deleteSubById(Integer id);

}
