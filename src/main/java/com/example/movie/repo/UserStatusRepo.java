package com.example.movie.repo;

import com.example.movie.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserStatusRepo extends JpaRepository<UserStatus,Integer> {
}
