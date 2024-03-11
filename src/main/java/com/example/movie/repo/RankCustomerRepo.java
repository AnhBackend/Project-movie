package com.example.movie.repo;

import com.example.movie.model.RankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankCustomerRepo extends JpaRepository<RankCustomer,Integer> {
}
