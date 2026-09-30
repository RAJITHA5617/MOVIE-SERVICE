package com.movies.movie_service.api;

import com.movies.movie_service.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerintTest {
    @Autowired
    MockMvc mockmvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void givenMovie_whenCreateMovie_thenSaveMovie() throws Exception{
        
        //Given
        Movie movie = new Movie();
        movie.setName("Bujjigadu");
        movie.setDirector("Puri");
        movie.setActors(List.of("Prabhas, Thisha"));

        //when createmovie
        mockmvc.perform(post("/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(movie)));

        // thensavemovi

    }
    

}