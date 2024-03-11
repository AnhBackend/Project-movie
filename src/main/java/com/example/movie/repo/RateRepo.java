package com.example.movie.repo;

import com.example.movie.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepo extends JpaRepository<Rate,Integer> {
}
