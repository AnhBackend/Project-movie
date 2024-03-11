package com.example.movie.repo;

import com.example.movie.model.Movie;
import com.example.movie.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
    @Query("SELECT DISTINCT s.movie FROM Schedule s JOIN s.room1 r JOIN r.seatList seat JOIN seat.seatStatus seatStatus WHERE r.cinema.Id = :cinemaId AND r.Id = :roomId AND seatStatus.Id = :seatStatusId")
    List<Movie> findMoviesByCinemaRoomAndSeatStatus(@Param("cinemaId") int cinemaId, @Param("roomId") int roomId, @Param("seatStatusId") int seatStatusId);
}
