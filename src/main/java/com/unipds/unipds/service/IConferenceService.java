package com.unipds.unipds.service;

import com.unipds.unipds.model.Conference;

import java.util.List;

public interface IConferenceService {
    public Conference addConference(Conference conference);
    public Conference getConferenceById(Integer id);
    public List<Conference> getAllConferences();
    public Conference updateConferenceById(Conference conference, Integer id);
    public void deleteConferenceById(Integer id);
}
