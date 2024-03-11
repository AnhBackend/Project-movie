package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "rates")
@Getter
@Setter
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "description")
    private String Description;
    @Column(name = "code")
    private String Code;
    @OneToMany(mappedBy = "rate")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Movie> movieList;

}
