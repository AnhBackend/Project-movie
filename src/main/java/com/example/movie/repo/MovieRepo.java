package com.example.movie.repo;

import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    @Query("SELECT m, COUNT(t) FROM Movie m LEFT JOIN m.scheduleList s LEFT JOIN s.ticketList t GROUP BY m ORDER BY COUNT(t) DESC")
    List<Object[]> findTopMoviesWithTicketCount(int pageable);
}
