package com.example.movie.repo;

import com.example.movie.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepo extends JpaRepository<Promotion,Integer> {
}
