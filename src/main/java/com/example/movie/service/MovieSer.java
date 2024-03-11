package com.example.movie.service;

import com.example.movie.DTO.MovieDTO;
import com.example.movie.model.Movie;
import com.example.movie.repo.MovieRepo;
import com.example.movie.repo.MovieTypeRepo;
import com.example.movie.repo.RateRepo;
import com.example.movie.repo.ScheduleRepo;
import com.example.movie.requestModels.SuaMovie_Request;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSer {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    MovieTypeRepo movieTypeRepo;
    @Autowired
    RateRepo rateRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    public List<Movie> getAllMovie(){
        return movieRepo.findAll();
    }
    public Movie getMovieById(int movieId) {
        return movieRepo.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + movieId));
    }
    public void addMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setMovieDuration(movieDTO.getMovieDuration());
        movie.setEndTime(movieDTO.getEndTime());
        movie.setPremiereDate(movieDTO.getPremiereDate());
        movie.setDescription(movieDTO.getDescription());
        movie.setDirector(movieDTO.getDirector());
        movie.setImage(movieDTO.getImage());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setHeroImage(movieDTO.getHeroImage());
        movie.setName(movieDTO.getName());
        movie.setIsActive(true);
        movie.setMovieType(movieTypeRepo.findById(5).get());
        movie.setRate(rateRepo.findById(5).get());
        movieRepo.save(movie);
    }
    public Optional<Movie> updateMovie(int movieId, SuaMovie_Request suaMovie_request){
        Optional<Movie> movie = movieRepo.findById(movieId);
        if (movie.isPresent()){
            Movie movie1 = new Movie();
            movie1.setMovieDuration(suaMovie_request.getMovieDuration());
            movie1.setEndTime(suaMovie_request.getEndTime());
            movie1.setPremiereDate(suaMovie_request.getPremiereDate());
            movie1.setDescription(suaMovie_request.getDescription());
            movie1.setDirector(suaMovie_request.getDirector());
            movie1.setImage(suaMovie_request.getImage());
            movie1.setLanguage(suaMovie_request.getLanguage());
            movie1.setHeroImage(suaMovie_request.getHeroImage());
            movie1.setName(suaMovie_request.getName());
            movie1.setTrailer(suaMovie_request.getTrailer());
            movie1.setMovieType(movieTypeRepo.findById(suaMovie_request.getMovieTypeId()).get());
            movie1.setRate(rateRepo.findById(suaMovie_request.getRateId()).get());
            return Optional.of(movieRepo.save(movie1));
        }
        else {
            return Optional.empty();
        }
    }
    public void deleteMovie(Integer movieId) throws Exception{
        Optional<Movie> movie = movieRepo.findById(movieId);
        if (movie.isPresent()){
            movieRepo.delete(movie.get());
        }
        else {
            throw new Exception("MovieId not found");
        }
    }
    public List<Object[]> getTopMoviesByTicketSales(int limit) {
       return movieRepo.findTopMoviesWithTicketCount(limit);
    }
    public List<Movie> getMoviesByCinemaRoomAndSeatStatus(int cinemaId, int roomId, int seatStatusId){
        return scheduleRepo.findMoviesByCinemaRoomAndSeatStatus(cinemaId,roomId,seatStatusId);
    }
}
