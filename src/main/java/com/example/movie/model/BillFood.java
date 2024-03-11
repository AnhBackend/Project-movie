package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "billFoods")
@Getter
@Setter
public class BillFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name ="quantity")
    private int Quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billid")
    @JsonIgnore
    Bill bill1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodid")
    @JsonIgnore
    Food food;
}
