package com.unipds.unipds.repo;

import com.unipds.unipds.model.Conference;
import org.springframework.data.repository.ListCrudRepository;

public interface ConferenceRepo extends ListCrudRepository<Conference, Integer> {
}
