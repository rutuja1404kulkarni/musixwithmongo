//package com.stackroute.musixservice.seeddata;
//
//import com.stackroute.musixservice.model.Track;
//import com.stackroute.musixservice.service.TrackService;
//import com.stackroute.musixservice.service.TrackServiceImpl;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//@Data
//@PropertySource("classpath:application.properties")
//public class SeedData implements CommandLineRunner
//{
//    @Autowired
//    Environment environment;
//
//    @Autowired
//    TrackService trackService;
////  @Autowired
//    Track track=new Track();
//
//    @Override
//    public void run(String... args) throws Exception {
//        track.setTrackName(environment.getProperty("track-name"));
//        track.setComment(environment.getProperty("track-comment"));
//        trackService.addMusic(track);
//
//    }
//}
