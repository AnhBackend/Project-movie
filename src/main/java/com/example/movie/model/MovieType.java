package com.example.movie.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
@Entity
@Table(name = "movieTypes")
@Getter
@Setter
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @OneToMany(mappedBy = "movieType")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Movie> movieList;

    @Column(name = "movietypename")
    private String MovieTypeName;
    @Column(name = "isactive")
    private boolean IsAcTive;
}
