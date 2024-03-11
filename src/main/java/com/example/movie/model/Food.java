package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "foods")
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "price")
    private double Price;
    @Column(name = "description")
    private String Description;
    @Column(name = "image")
    private String Image;
    @Column(name = "nameoffood")
    private String NameOfFood;
    @Column(name = "isactive")
    private boolean IsActive;
    @OneToMany(mappedBy = "food")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<BillFood> billFoodList;

}
