package com.stackroute.musixservice.service;

import com.stackroute.musixservice.exception.TrackAlreadyExistsException;
import com.stackroute.musixservice.exception.TrackNotFoundException;
import com.stackroute.musixservice.model.Track;

import java.util.List;

import java.util.Optional;

public interface TrackService {
    public Track addMusic(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllMusic() throws TrackNotFoundException;

    public void deleteMusic(int track) throws TrackNotFoundException;

    public Optional<Track> findTrackById(int id) throws TrackNotFoundException;
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;

}