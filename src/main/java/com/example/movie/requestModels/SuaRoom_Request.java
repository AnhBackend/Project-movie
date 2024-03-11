package com.example.movie.requestModels;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuaRoom_Request {
    private int Capacity;
    private int Type;
    private String Description;
    private String Code;
    private String Name;
    private Integer cinemaId;
}
