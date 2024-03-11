package com.example.movie.service;

import com.example.movie.DTO.UserRegistrationDTO;
import com.example.movie.repo.ConfirmEmailRepo;
import com.example.movie.repo.RoleRepo;
import com.example.movie.repo.UserRepo;
import com.example.movie.model.User;
import com.example.movie.repo.UserStatusRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSer {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserStatusRepo userStatusRepo;
    @Autowired
    ConfirmEmailRepo confirmEmailRepo;
    public void registerUser(UserRegistrationDTO userRegistrationDTO){
            User user = new User();
            user.setEmail(userRegistrationDTO.getEmail());
            user.setIsActive(true);
            user.setName(userRegistrationDTO.getName());
            user.setPassword(userRegistrationDTO.getPassword());
            user.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
            user.setPoint(userRegistrationDTO.getPoint());
            user.setUserName(userRegistrationDTO.getUserName());
            user.setRole(roleRepo.findById(4).get());
            user.setUserStatus(userStatusRepo.findById(2).get());
            userRepo.save(user);
    }
    public User getUserById(int userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}

