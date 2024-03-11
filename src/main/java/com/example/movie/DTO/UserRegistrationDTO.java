package com.example.movie.DTO;

import com.example.movie.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {
    private String Email;
    private boolean isactive;
    private String Name;
    private String Password;
    private String PhoneNumber;
    private int Point;
    private String UserName;
    public static UserRegistrationDTO fromEntity(User user){
        return new UserRegistrationDTO(
                user.getEmail(),
                true,
                user.getUserName(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getPoint(),
                user.getUserName()
        );
    }

}

