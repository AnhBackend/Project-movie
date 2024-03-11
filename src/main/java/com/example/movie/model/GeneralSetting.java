package com.example.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "GeneralSettings")
@Getter
@Setter
public class GeneralSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "breaktime")
    private LocalDateTime BreakTime;
    @Column(name = "businesshours")
    private int BusinessHours;
    @Column(name = "closetime")
    private LocalDateTime CloseTime;
    @Column(name = "fixedticketprice")
    private double FixedTicketPrice;
    @Column(name = "percentday")
    private int PercentDay;
    @Column(name = "percentweekend")
    private int PercentWeekend;
    @Column(name = "timebegintochange")
    private LocalDateTime TimeBeginToChange;
}
