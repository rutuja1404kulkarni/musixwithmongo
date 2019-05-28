package com.stackroute.musixservice.controller;

import com.stackroute.musixservice.exception.TrackAlreadyExistsException;
import com.stackroute.musixservice.exception.TrackNotFoundException;
import com.stackroute.musixservice.service.TrackService;
import com.stackroute.musixservice.service.TrackServiceImpl;
import com.stackroute.musixservice.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TrackController  {
    @Autowired
    private TrackService trackService;
    ResponseEntity responseEntity;
    public TrackService getTrackServiceImpl()
    {
        return trackService;
    }

    public void setTrackService(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("/music")
    public ResponseEntity<Track> addMusic(@RequestBody Track track) {
        try {
            return new ResponseEntity<>(trackService.addMusic(track), HttpStatus.OK);
        }
        catch (TrackAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return responseEntity;
    }

    @PutMapping("/music/{id}")
    public ResponseEntity<Track> updateMusic(@RequestBody Track track,@PathVariable int id) {
        try {
            track.setTrackId(id);
            return new ResponseEntity<>(trackService.addMusic(track), HttpStatus.OK);
        }
        catch (Exception e) {
        }
        return responseEntity;
    }

    @GetMapping("/music")
    public ResponseEntity<List<Track>> getMusic() {
        ResponseEntity responseEntity;
        try {

            responseEntity= new ResponseEntity<>(trackService.getAllMusic(), HttpStatus.OK);
        }
        catch (TrackNotFoundException e)
        {
            e.getMessage();
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        catch (Exception e)
        {
            e.getMessage();
            responseEntity=new ResponseEntity("Something went wrong",HttpStatus.CONFLICT);

        }

        return  responseEntity;
    }

    @Value("$(delete.message)")
    private String deleteMessage;
    @DeleteMapping("/music/{id}")
    public ResponseEntity<String> deleteMusic(@PathVariable int id) {
        try {
            trackService.deleteMusic(id);
            return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
        }
        catch (TrackNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        return responseEntity;
    }

//    @GetMapping("/music/{id}")
//    public ResponseEntity<Optional<Track>> getById(@PathVariable int id ) {
//        try {
//            // trackServiceImpl.findByTrackId(id);
//            return new ResponseEntity<Optional<Track>>(trackServiceImpl.findTrackById(id), HttpStatus.OK);
//        }catch (TrackNotFoundException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        return responseEntity;
//    }

//    @GetMapping(value ="track/{trackName}")
//    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) throws Exception {
//        List<Track> trackOne = trackService.getTrackByName(trackName);
//        return new ResponseEntity<List<Track>>(trackOne, HttpStatus.OK);
//    }

}
