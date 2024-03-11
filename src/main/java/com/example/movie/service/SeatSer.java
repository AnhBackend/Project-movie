package com.example.movie.service;

import com.example.movie.DTO.SeatDTO;
import com.example.movie.model.Seat;
import com.example.movie.repo.RoomRepo;
import com.example.movie.repo.SeatRepo;
import com.example.movie.repo.SeatStatusRepo;
import com.example.movie.repo.SeatTypeRepo;
import com.example.movie.requestModels.SuaSeat_Request;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatSer {
    @Autowired
    SeatRepo seatRepo;
    @Autowired
    SeatStatusRepo seatStatusRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    SeatTypeRepo seatTypeRepo;
    public List<Seat> getAllSeat(){
        return seatRepo.findAll();
    }
    public Seat getSeatById(int seatId) {
        return seatRepo.findById(seatId)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + seatId));
    }
    public void addSeat(SeatDTO seatDTO){
        Seat seat = new Seat();
        seat.setNumber(seatDTO.getNumber());
        seat.setLine(seatDTO.getLine());
        seat.setIsActive(true);
        seat.setSeatStatus(seatStatusRepo.findById(1).get());
        seat.setSeatType(seatTypeRepo.findById(1).get());
        seat.setRoom(roomRepo.findById(6).get());
        seatRepo.save(seat);
    }
    public Optional<Seat> updateSeat(int seatId, SuaSeat_Request updateSeat){
        Optional<Seat> seat = seatRepo.findById(seatId);
        if (seat.isPresent()){
            Seat seat1 = new Seat();
            seat1.setNumber(updateSeat.getNumber());
            seat1.setLine(updateSeat.getLine());
            seat1.setSeatStatus(seatStatusRepo.findById(updateSeat.getSeatStatusId()).get());
            seat1.setSeatType(seatTypeRepo.findById(updateSeat.getSeatTypeId()).get());
            seat1.setRoom(roomRepo.findById(updateSeat.getRoomId()).get());
            return Optional.of(seatRepo.save(seat1));
        }
        else {
            return Optional.empty();
        }
    }
    public void deleteSeat(Integer seatId) throws Exception{
        Optional<Seat> seat = seatRepo.findById(seatId);
        if (seat.isPresent()){
            seatRepo.delete(seat.get());
        }
        else {
            throw new Exception("SeatId not found");
        }
    }
}
