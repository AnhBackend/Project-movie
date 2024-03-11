package com.example.movie.service;

import com.example.movie.model.Cinema;
import com.example.movie.repo.CinemaRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaSer {
    @Autowired
    CinemaRepo cinemaRepo;
    public List<Cinema> getAllCinema(){
        return cinemaRepo.findAll();
    }
    public Cinema getCinemaById(int cinemaId) {
        return cinemaRepo.findById(cinemaId)
                .orElseThrow(() -> new EntityNotFoundException("Cinema not found with id: " + cinemaId));
    }
    public Cinema addCinema(Cinema cinema){
        return cinemaRepo.save(cinema);
    }
    public Optional<Cinema> updateCinema(int cinemaId,Cinema cinema){
        Optional<Cinema> optionalCinema = cinemaRepo.findById(cinemaId);
        if (optionalCinema.isPresent()){
            Cinema cinema1 = optionalCinema.get();
            BeanUtils.copyProperties(cinema,cinema1,"id");
            return Optional.of(cinemaRepo.save(cinema1));
        }
        else return Optional.empty();
    }
    public boolean deleteCinema(int cinemaId){
        if (cinemaRepo.existsById(cinemaId)){
            cinemaRepo.deleteById(cinemaId);
            return true;
        }
        return false;
    }
}

