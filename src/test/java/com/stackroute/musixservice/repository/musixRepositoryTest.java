package com.stackroute.musixservice.repository;

import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.service.TrackService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest

//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class musixRepositoryTest
{
    @Autowired
    private TrackRepository trackRepository;
    private Track track;


    @Before
    public void setUp()
    {
       track = new Track();
       track.setTrackId(1);
        track.setTrackName("Tere liye");
        track.setComment("Good");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }

    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
       Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(1,fetchTrack.getTrackId());

    }

    @Test
    public void testSaveTrackFailure(){
       Track testTrack = new Track(1,"tu hi re","good song");
        trackRepository.save(track);
     // Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAllTrack(){
        Track track1 = new Track(2,"abcd","good");
        Track track2 = new Track(3,"Jenny","great");
        trackRepository.save(track1);
        trackRepository.save(track2);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("abcd",list.get(0).getTrackName());
    }

}
