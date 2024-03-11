package com.example.movie.repo;

import com.example.movie.model.ConfirmEmail;
import com.example.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConfirmEmailRepo extends JpaRepository<ConfirmEmail, Integer>{
//    ConfirmEmail finByUser(User user);
//    ConfirmEmail senConfirmationEmail(String email,String confirmationCode);
}
