package com.example.movie.requestModels;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuaMovie_Request {
    private int MovieDuration;
    private LocalDateTime EndTime;
    private LocalDateTime PremiereDate;
    private String Description;
    private String Director;
    private String Image;
    private String Language;
    private String HeroImage;
    private String Name;
    private String Trailer;
    private Integer movieTypeId;
    private Integer rateId;
}
