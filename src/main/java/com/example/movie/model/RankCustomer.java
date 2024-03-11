package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "rankCustomers")
@Getter
@Setter
public class RankCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "point")
    private int Point;
    @Column(name = "description")
    private String Description;
    @Column(name = "name")
    private String Name;
    @Column(name = "isactive")
    private boolean IsActive;
    @OneToMany(mappedBy = "rankCustomer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Promotion> promotionList;

    @OneToMany(mappedBy = "rankCustomer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<User> userList;
}
