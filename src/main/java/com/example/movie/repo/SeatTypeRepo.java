package com.example.movie.repo;

import com.example.movie.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SeatTypeRepo extends JpaRepository<SeatType,Integer> {
}
