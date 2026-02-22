package com.unipds.unipds.repo;

import com.unipds.unipds.model.Session;
import org.springframework.data.repository.ListCrudRepository;

public interface SessionRepo extends ListCrudRepository<Session, Integer> {
}
