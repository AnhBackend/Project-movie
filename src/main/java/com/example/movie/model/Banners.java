package com.example.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "banners")
@Getter
@Setter
public class Banners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "imageurl")
    private String ImageUrl;
    @Column(name = "title")
    private String Title;
}
