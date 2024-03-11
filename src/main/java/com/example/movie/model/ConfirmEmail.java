package com.example.movie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "confirmEmails")
@Getter
@Setter
public class ConfirmEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnore
    User user3;
    @Column(name = "requireddatetime")
    private LocalDateTime RequiredDateTime;
    @Column(name = "expireddatetime")
    private LocalDateTime ExpiredDateTime;
    @Column(name = "confirmcode")
    private String ConfirmCode;
    @Column(name = "isconfirm")
    private boolean IsConfirm;

}
