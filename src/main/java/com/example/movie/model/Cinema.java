package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "cinemas")
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "address")
    private String Address;
    @Column(name = "description")
    private String Description;
    @Column(name = "code")
    private String Code;
    @Column(name = "nameofcinema")
    private String NameOfCinema;
    @Column(name = "isactive")
    private boolean IsActive;
    @OneToMany(mappedBy = "cinema")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Room> roomList;
}
