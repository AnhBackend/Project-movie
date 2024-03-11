package com.example.movie.repo;

import com.example.movie.model.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillStatusRepo extends JpaRepository<BillStatus,Integer> {
}
