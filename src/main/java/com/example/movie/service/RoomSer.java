package com.example.movie.service;

import com.example.movie.DTO.RoomDTO;
import com.example.movie.model.Cinema;
import com.example.movie.model.Room;
import com.example.movie.repo.*;
import com.example.movie.requestModels.SuaRoom_Request;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomSer {
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    CinemaRepo cinemaRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    SeatRepo seatRepo;
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    BillTicketRepo billTicketRepo;

    public List<Room> getAllRoom(){
        return roomRepo.findAll();
    }
    public Room getRoomById(int roomId) {
        return roomRepo.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with id: " + roomId));
    }
    public void addRoom(RoomDTO roomDTO){
        Room room = new Room();
        room.setCapacity(roomDTO.getCapacity());
        room.setType(roomDTO.getType());
        room.setDescription(roomDTO.getDescription());
        room.setCode(roomDTO.getCode());
        room.setName(roomDTO.getName());
        room.setIsActive(true);
        room.setCinema(cinemaRepo.findById(3).get());
        roomRepo.save(room);
    }
    private void checkCinemaId(int cinemaId){
        Optional<Cinema> cinema = cinemaRepo.findById(cinemaId);
        if (cinema.isEmpty()){
            System.out.println("Cinema id"+cinemaId+" không tồn tại.");
        }
    }
    public Optional<Room> updateRoom(int roomId, SuaRoom_Request updateRoom){
        Optional<Room> optionalRoom = roomRepo.findById(roomId);
        if (optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            room.setCapacity(updateRoom.getCapacity());
            room.setType(updateRoom.getType());
            room.setDescription(updateRoom.getDescription());
            room.setName(updateRoom.getName());
            room.setCode(updateRoom.getCode());
            room.setCinema(cinemaRepo.findById(updateRoom.getCinemaId()).get());
            return Optional.of(roomRepo.save(room));
        }
        else {
            return Optional.empty();
        }
    }
    public void deleteRoom(Integer roomId) throws Exception {
        Optional<Room> room = roomRepo.findById(roomId);
        if (room.isPresent()){
            roomRepo.delete(room.get());
        }
        else {
            throw new Exception("RoomId not found");
        }
    }
}
