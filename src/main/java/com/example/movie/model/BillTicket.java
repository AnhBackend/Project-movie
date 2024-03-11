package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "billTickets")
@Getter
@Setter
public class BillTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "quantity")
    private int Quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billid")
    @JsonIgnore
    Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketid")
    @JsonIgnore
    Ticket ticket;
}
