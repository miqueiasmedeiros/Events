package com.unipds.unipds.service;

import com.unipds.unipds.exception.NotFoundException;
import com.unipds.unipds.model.Conference;
import com.unipds.unipds.repo.ConferenceRepo;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements IConferenceService{
    private final ConferenceRepo repo;

    public ConferenceServiceImpl(ConferenceRepo repo){
        super();
        this.repo = repo;
    }

    @Override
    public Conference addConference(Conference conference){
        return repo.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer id) {
        return repo.findById(id).orElseThrow(()-> new NotFoundException("Conference not found: "+ id));
    }

    @Override
    public List<Conference> getAllConferences() {
        return repo.findAll();
    }

    @Override
    public Conference updateConferenceById(Conference conference, Integer id) {
        return null;
    }
}
