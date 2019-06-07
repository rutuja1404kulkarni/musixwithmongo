package com.stackroute.musixservice.repository;

import com.stackroute.musixservice.model.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//repository class
@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {

}
