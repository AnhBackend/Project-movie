package com.example.movie.repo;

import com.example.movie.model.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MovieTypeRepo extends JpaRepository<MovieType,Integer> {
}
