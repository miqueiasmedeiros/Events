package com.unipds.unipds.service;

import com.unipds.unipds.exception.NotFoundException;
import com.unipds.unipds.model.Session;
import com.unipds.unipds.repo.SessionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService{

    private SessionRepo repo;

    public SessionServiceImpl(SessionRepo repo){
        super();
        this.repo = repo;
    }


    @Override
    public Session addSession(Session session) {
        return repo.save(session);
    }

    @Override
    public Session getSessionById(Integer id) {
        return repo.findById(id).orElseThrow(()-> new NotFoundException("Session "+id+" not found"));
    }

    @Override
    public List<Session> getAllSessions() {
        return repo.findAll();
    }

    @Override
    public Session updateSessionById(Session session, Integer id) {
        Session updateSession = repo.findById(id).orElseThrow(()-> new NotFoundException("id "+id+" not found for updated"));
        updateSession.setTitle(session.getTitle());
        updateSession.setStartDate(session.getStartDate());
        updateSession.setStartTime(session.getStartTime());
        return repo.save(updateSession);
    }

    @Override
    public void deleteSessionById(Integer id) {
        if (!repo.existsById(id)){
            throw new NotFoundException("id "+id+" not found");
        }
        repo.deleteById(id);
    }
}
