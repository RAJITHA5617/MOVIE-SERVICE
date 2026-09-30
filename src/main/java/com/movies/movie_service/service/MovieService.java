package com.movies.movie_service.service;

import com.movies.movie_service.exception.InvalidDataException;
import com.movies.movie_service.exception.MovieNotFoundException;
import com.movies.movie_service.model.Movie;
import com.movies.movie_service.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    //CRED operations
    public Movie create(Movie movie){
        if(movie == null){
            throw new InvalidDataException("Invalid Movie:null");
        }

        return movieRepository.save(movie);
    }
    public Movie read(Long id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id:" + id));
    }
     public void update(Long id, Movie updateMovie){
         if(updateMovie == null || id==null){
             throw new InvalidDataException("Invalid Movie: null");
         }
         // check if exists
         if(movieRepository.existsById(id)){
             Movie movie = movieRepository.getReferenceById(id);
             movie.setName(updateMovie.getName());
             movie.setDirector(updateMovie.getDirector());
             movie.setActors(updateMovie.getActors());
             movieRepository.save(movie);
         } else{
             throw new MovieNotFoundException("Movie not found with id:" + id);
         }
         
     }
     public void delete(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
         } else{
            throw new MovieNotFoundException("Movie not found with id:" + id);
         }

     }
     
}
