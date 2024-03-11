package com.example.movie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "point")
    private int Point;
    @Column(name = "username")
    private String UserName;
    @Column(name = "email")
    private String Email;
    @Column(name = "name")
    private String Name;
    @Column(name = "phonenumber")
    private String PhoneNumber;
    @Column(name = "password")
    private String Password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rankcustomerid")
    @JsonIgnore
    RankCustomer rankCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userstatusid")
    @JsonIgnore
    UserStatus userStatus;

    @Column(name = "isactive")
    private boolean IsActive;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    @JsonIgnore
    Role role;

    @OneToMany(mappedBy = "user2")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<RefreshToken> refreshTokenList;

    @OneToMany(mappedBy = "user3")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<ConfirmEmail> confirmEmailList;

    @OneToMany(mappedBy = "user1")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Bill> billList;
}
