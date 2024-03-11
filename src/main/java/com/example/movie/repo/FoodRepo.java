package com.example.movie.repo;

import com.example.movie.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FoodRepo extends JpaRepository<Food,Integer> {
}
