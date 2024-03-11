package com.example.movie.repo;

import com.example.movie.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepo extends JpaRepository<Cinema,Integer> {
}
