package com.unipds.unipds.repo;

import com.unipds.unipds.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepo extends ListCrudRepository<User, Integer> {

    public Optional<User> findByEmail(String email);
}
