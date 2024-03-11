package com.example.movie.repo;

import com.example.movie.model.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SeatStatusRepo extends JpaRepository<SeatStatus,Integer> {
}
