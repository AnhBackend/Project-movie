package com.example.movie.repo;

import com.example.movie.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("ALL")
public interface BillRepo extends JpaRepository<Bill,Integer> {
    @Query("SELECT NEW com.example.movie.DTO.RevenueReport(b.cinema.name, SUM(b.totalAmount)) FROM Bill b WHERE b.cinema.id = :cinemaId AND b.createdAt BETWEEN :startDate AND :endDate GROUP BY b.cinema.name")
    List<Object[]> findTotalRevenueByCinemaAndDateRange(@Param("cinemaId") int cinemaId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
