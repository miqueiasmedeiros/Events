package com.unipds.unipds.service;

import com.unipds.unipds.model.Session;

import java.util.List;

public interface ISessionService {
    public Session addSession(Session session);
    public Session getSessionById(Integer id);
    public List<Session> getAllSessions();
}
