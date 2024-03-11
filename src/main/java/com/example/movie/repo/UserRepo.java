package com.example.movie.repo;

import com.example.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
//    User finByEmail(String email);
//    boolean existsByEmail(String email);
//    boolean existsByUserName(String userName);
}
