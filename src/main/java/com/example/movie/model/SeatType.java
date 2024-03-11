package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "seatTypes")
@Getter
@Setter
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "nametype")
    private String NameType;
    @OneToMany(mappedBy = "seatType")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Seat> seatList;
}
