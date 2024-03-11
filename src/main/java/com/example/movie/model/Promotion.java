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
@Table(name = "promotions")
@Getter
@Setter
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "percent")
    private int Percent;
    @Column(name = "quantity")
    private int Quantity;
    @Column(name = "type")
    private String Type;
    @Column(name = "starttime")
    private LocalDateTime StartTime;
    @Column(name = "endtime")
    private LocalDateTime EndTime;
    @Column(name = "description")
    private String Description;
    @Column(name = "name")
    private String Name;
    @Column(name = "isactive")
    private boolean IsActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rankcustomerid")
    @JsonIgnore
    RankCustomer rankCustomer;

    @OneToMany(mappedBy = "promotion")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Bill> billList;
}
