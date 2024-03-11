package com.example.movie.repo;

import com.example.movie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SeatRepo extends JpaRepository<Seat,Integer> {
}
