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
@Table(name = "bills")
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "totalmoney")
    private double TotalMoney;
    @Column(name = "tradingcode")
    private String TradingCode;
    @Column(name = "createtime")
    private LocalDateTime CreateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnore
    User user1;
    @Column(name = "name")
    private String Name;
    @Column(name = "createat")
    private LocalDateTime CreateAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotionid")
    @JsonIgnore
    Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billstatusid")
    @JsonIgnore
    BillStatus billStatus;
    @Column(name = "isactive")
    private boolean IsActive;
    @OneToMany(mappedBy = "bill")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<BillTicket> billTicketList;

    @OneToMany(mappedBy = "bill1")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<BillFood> billFoodList;
}
