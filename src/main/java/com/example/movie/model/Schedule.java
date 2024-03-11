package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "schedules")
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "price")
    private double Price;
    @Column(name = "starat")
    private LocalDateTime StarAt;
    @Column(name = "endat")
    private LocalDateTime EndAt;
    @Column(name = "code")
    private String Code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieid")
    @JsonIgnore
    Movie movie;

    @Column(name = "name")
    private String Name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomid")
    @JsonIgnore
    Room room1;

    @Column(name = "isactive")
    private boolean IsActive;

    @OneToMany(mappedBy = "schedule")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Ticket> ticketList;
}
