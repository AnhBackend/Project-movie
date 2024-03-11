package com.example.movie.model;


import com.example.movie.DTO.RoomDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "capacity")
    private int Capacity;
    @Column(name = "type")
    private int Type;
    @Column(name = "description")
    private String Description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaid")
    @JsonIgnore
    Cinema cinema;

    @Column(name = "code")
    private String Code;
    @Column(name = "name")
    private String Name;
    @Column(name = "isactive")
    private boolean IsActive;

    @OneToMany(mappedBy = "room")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Seat> seatList;

    @OneToMany(mappedBy = "room1")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Schedule> scheduleList;

}
