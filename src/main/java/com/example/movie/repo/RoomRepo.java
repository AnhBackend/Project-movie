package com.example.movie.repo;

import com.example.movie.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepo extends JpaRepository<Room,Integer> {
}
