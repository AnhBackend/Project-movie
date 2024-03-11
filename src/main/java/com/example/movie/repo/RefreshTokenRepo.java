package com.example.movie.repo;

import com.example.movie.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken,Integer> {
}
