package com.example.movie.DTO;

import com.example.movie.model.Cinema;
import com.example.movie.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private int Capacity;
    private int Type;
    private String Description;
    private String Code;
    private String Name;
    private boolean IsActive;
    public static RoomDTO fromEntity(Room room){
        return new RoomDTO(
                room.getCapacity(),
                room.getType(),
                room.getDescription(),
                room.getCode(),
                room.getName(),
                room.isIsActive()
        );
    }
}
