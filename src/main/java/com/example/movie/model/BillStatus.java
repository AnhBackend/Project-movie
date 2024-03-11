package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "billStatuses")
@Getter
@Setter
public class BillStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "name")
    private String Name;
    @OneToMany(mappedBy = "billStatus")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Bill> billList;
}
