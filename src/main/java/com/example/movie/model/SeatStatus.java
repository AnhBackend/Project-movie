package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "seatsStatus")
@Getter
@Setter
public class SeatStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "code")
    private String Code;

    @Column(name = "namestatus")
    private String NameStatus;
    @OneToMany(mappedBy = "seatStatus")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Seat> seatList;
}
