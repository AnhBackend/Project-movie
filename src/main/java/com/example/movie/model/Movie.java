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
@Table(name = "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "movieduration")
    private int MovieDuration;
    @Column(name = "endtime")
    private LocalDateTime EndTime;
    @Column(name = "premieredate")
    private LocalDateTime PremiereDate;
    @Column(name = "description")
    private String Description;
    @Column(name = "director")
    private String Director;
    @Column(name = "image")
    private String Image;
    @Column(name = "language")
    private String Language;
    @Column(name = "heroimage")
    private String HeroImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movietypeid")
    @JsonIgnore
    MovieType movieType;
    @Column(name = "name")
    private String Name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rateid")
    @JsonIgnore
    Rate rate;
    @Column(name = "trailer")
    private String Trailer;
    @Column(name = "isactive")
    private boolean IsActive;
    @OneToMany(mappedBy = "movie")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Schedule> scheduleList;
}
