package com.example.movie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "seats")
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name ="number")
    private int Number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatstatusid")
    @JsonIgnore
    SeatStatus seatStatus;


    @Column(name = "line")
    private String Line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomid")
    @JsonIgnore
    Room room;
    @Column(name = "isactive")
    private boolean IsActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seattypeid")
    @JsonIgnore
    SeatType seatType;

    @OneToMany(mappedBy = "seat")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Ticket> ticketList;
}
