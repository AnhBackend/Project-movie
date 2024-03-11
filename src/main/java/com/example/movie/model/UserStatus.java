package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "userstatuses")
@Getter
@Setter
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "code")
    private String Code;
    @Column(name = "name")
    private String Name;
    @OneToMany(mappedBy = "userStatus")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<User> userList;
}
