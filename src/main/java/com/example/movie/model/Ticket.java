package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "code")
    private String Code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleid")
    @JsonIgnore
    Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatid")
    @JsonIgnore
    Seat seat;

    @Column(name = "priceticket")
    private double PriceTicket;

    @Column(name = "isactive")
    private boolean IsActive;
    @OneToMany(mappedBy = "ticket")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<BillTicket> billTicketList;
}
