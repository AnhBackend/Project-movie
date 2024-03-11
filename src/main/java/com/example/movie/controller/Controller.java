package com.example.movie.controller;

import com.example.movie.DTO.*;
import com.example.movie.model.*;
import com.example.movie.requestModels.SuaMovie_Request;
import com.example.movie.requestModels.SuaRoom_Request;
import com.example.movie.requestModels.SuaSeat_Request;
import com.example.movie.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    @Autowired
    UserSer userSer;
    @Autowired
    FoodSer foodSer;
    @Autowired
    CinemaSer cinemaSer;
    @Autowired
    RoomSer roomSer;
    @Autowired
    SeatSer seatSer;
    @Autowired
    MovieSer movieSer;
    @Autowired
    BillSer billSer;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        try {
            userSer.registerUser(userRegistrationDTO);
            return ResponseEntity.ok("Đăng ký thành công. Vui lòng kiểm tra email để xác nhận tài khoản");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @RequestMapping(value = "layttnguoidung",method = RequestMethod.GET)
    public ResponseEntity<User> getUserId(@RequestParam int userId){
        User user = userSer.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @RequestMapping(value = "getallusers",method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userSer.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    // FOOD
    @GetMapping(value = "/getallfood")
    public ResponseEntity<List<Food>> getAllFood() {
        List<Food> foods = foodSer.getAllFood();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
    @RequestMapping(value = "getfoodbyid",method = RequestMethod.GET)
    public ResponseEntity<Food> getFoodById(@RequestParam int foodId){
        Food food = foodSer.getFoodById(foodId);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }
    @PostMapping(value = "/addfood")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food addedFood = foodSer.addFood(food);
        return new ResponseEntity<>(addedFood, HttpStatus.CREATED);
    }
    @PutMapping("/updatefood")
    public ResponseEntity<Optional<Food>> updateFood(@RequestParam int foodId, @RequestBody Food updatedFood) {
        Optional<Food> food = foodSer.updateFood(foodId, updatedFood);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }
    @DeleteMapping("/deletefood")
    public ResponseEntity<?> deleteFood(@RequestParam int foodId) {
        boolean isDeleted = foodSer.deleteFood(foodId);
        if (isDeleted) {
            return ResponseEntity.ok("Xóa food thành công");
        } else {
            return ResponseEntity.ok("Xóa food thất bại");
        }
    }
    // CINEMA
    @GetMapping(value = "/getallcinema")
    public ResponseEntity<List<Cinema>> getAllCinema(){
        List<Cinema> cinemas = cinemaSer.getAllCinema();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }
    @RequestMapping(value = "getcinemabyid",method = RequestMethod.GET)
    public ResponseEntity<Cinema> getCinemaById(@RequestParam int cinemaId){
        Cinema cinema = cinemaSer.getCinemaById(cinemaId);
        return new ResponseEntity<>(cinema,HttpStatus.OK);
    }
    @PostMapping(value = "/addcinema")
    public ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
        Cinema addedCinema = cinemaSer.addCinema(cinema);
        return new ResponseEntity<>(addedCinema, HttpStatus.CREATED);
    }
    @PutMapping("/updatecinema")
    public ResponseEntity<Optional<Cinema>> updateCinema(@RequestParam int cinemaId, @RequestBody Cinema updatedCinema) {
        Optional<Cinema> cinema = cinemaSer.updateCinema(cinemaId, updatedCinema);
        return new ResponseEntity<>(cinema,HttpStatus.OK);
    }
    @DeleteMapping("/deletecinema")
    public ResponseEntity<?> deleteCinema(@RequestParam int cinemaId) {
        boolean isDeleted = cinemaSer.deleteCinema(cinemaId);
        if (isDeleted) {
            return ResponseEntity.ok("Xóa cinema thành công");
        } else {
            return ResponseEntity.ok("Xóa cinema thất bại");
        }
    }
    // ROOM
    @GetMapping(value = "/getallroom")
    public List<Room> getAllRoom(){
        return roomSer.getAllRoom();
    }
    @RequestMapping(value = "getroombyid",method = RequestMethod.GET)
    public ResponseEntity<Room> getRoomById(@RequestParam int roomId){
        Room room = roomSer.getRoomById(roomId);
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
    @RequestMapping(value = "/addroom",method = RequestMethod.POST)
    public ResponseEntity<?> addRoom(@RequestBody RoomDTO roomDTO){
        try {
            roomSer.addRoom(roomDTO);
            return ResponseEntity.ok("thêm room thành công.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/updateroom")
    public ResponseEntity<Optional<Room>> updateRoom(@RequestParam Integer roomid, @RequestBody SuaRoom_Request updatedRoom) {
        Optional<Room> room = roomSer.updateRoom(roomid, updatedRoom);
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteroom")
    public ResponseEntity<?> deleteRoom(@RequestParam Integer roomid) throws Exception {
        try {
            roomSer.deleteRoom(roomid);
            return ResponseEntity.ok().body("Xóa thành công");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Seat
    @GetMapping(value = "/getallseat")
    public List<Seat> getAllSeat(){
        return seatSer.getAllSeat();
    }
    @RequestMapping(value = "getseatbyid",method = RequestMethod.GET)
    public ResponseEntity<Seat> getSeatById(@RequestParam int seatId){
        Seat seat = seatSer.getSeatById(seatId);
        return new ResponseEntity<>(seat,HttpStatus.OK);
    }
    @RequestMapping(value = "/themseat",method = RequestMethod.POST)
    public ResponseEntity<?> addSeat(@RequestBody SeatDTO seatDTO){
        try {
            seatSer.addSeat(seatDTO);
            return ResponseEntity.ok("thêm seat thành công.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/updateseat")
    public ResponseEntity<Optional<Seat>> updateSeat(@RequestParam Integer seatid, @RequestBody SuaSeat_Request updatedSeat) {
        Optional<Seat> seat = seatSer.updateSeat(seatid, updatedSeat);
        return new ResponseEntity<>(seat,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteseat")
    public ResponseEntity<?> deleteSeat(@RequestParam Integer seatid) throws Exception {
        try {
            seatSer.deleteSeat(seatid);
            return ResponseEntity.ok().body("Xóa thành công");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Movie
    @GetMapping(value = "/getallmovie")
    public List<Movie> getAllMovie(){
        return movieSer.getAllMovie();
    }
    @RequestMapping(value = "getmoviebyid",method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@RequestParam int movieId){
        Movie movie = movieSer.getMovieById(movieId);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
    @RequestMapping(value = "/addmovie",method = RequestMethod.POST)
    public ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO){
        try {
            movieSer.addMovie(movieDTO);
            return ResponseEntity.ok("thêm movie thành công.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/updatemovie")
    public ResponseEntity<Optional<Movie>> updateMovie(@RequestParam Integer movieid, @RequestBody SuaMovie_Request suaMovie_request) {
        Optional<Movie> movie = movieSer.updateMovie(movieid, suaMovie_request);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletemovie")
    public ResponseEntity<?> deleteMovie(@RequestParam Integer movieid) throws Exception {
        try {
            movieSer.deleteMovie(movieid);
            return ResponseEntity.ok().body("Xóa thành công");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping(value = "/top")
    public List<Object[]> getTopMoviesByTicketSales(@RequestParam int limit){
        return movieSer.getTopMoviesByTicketSales(limit);
    }
    @GetMapping("/by-cinema-room-seat-status")
    public ResponseEntity<List<Movie>> getMoviesByCinemaRoomAndSeatStatus(@RequestParam int cinemaId,
                                                                          @RequestParam int roomId,
                                                                          @RequestParam int seatStatusId){
        List<Movie> movies = movieSer.getMoviesByCinemaRoomAndSeatStatus(cinemaId,roomId,seatStatusId);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    // TUAN4
    @GetMapping("/revenue-by-cinema")
    public ResponseEntity<List<RevenueReportDTO>> getRevenueReportByCinemaAndDateRange(
            @RequestParam int cinemaId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<RevenueReportDTO> revenueReports = billSer.getRevenueReportByCinemaAndDateRange(cinemaId, startDate, endDate);
        return new ResponseEntity<>(revenueReports, HttpStatus.OK);
    }
}
