package com.unipds.unipds.repo;

import com.unipds.unipds.model.Session;
import com.unipds.unipds.model.Subscription;
import com.unipds.unipds.model.SubscriptionID;
import com.unipds.unipds.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SubscriptionRepo extends ListCrudRepository<Subscription, SubscriptionID> {

    public List<Subscription> findByIdUser(User user);
    public List<Subscription> findByIdSession(Session session);
}
