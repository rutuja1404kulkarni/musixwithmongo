package com.stackroute.musixservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.musixservice.exception.TrackAlreadyExistsException;
import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.service.TrackService;
import com.stackroute.musixservice.service.TrackServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class musixControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    private Track track;

    @MockBean
    TrackService trackService;

    @InjectMocks
    TrackController trackController;

    private List<Track> list=null;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(trackController).build();
        track=new Track();
        track.setTrackName("tu hi re");
        track.setComment("good song");
        list=new ArrayList<>();
        list.add(track);

    }

    @Test
    public void saveTrack() throws Exception {
        when(trackService.addMusic(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void saveTrackFailure() throws Exception {
        when(trackService.addMusic(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllTrack() throws Exception {
        when(trackService.getAllMusic()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getAllUserFailure() throws Exception {
        when(trackService.getAllMusic()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
