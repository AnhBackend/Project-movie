package com.example.movie;

import com.example.movie.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApplication implements CommandLineRunner {
    @Autowired
    private UserRepo _re;
    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var a = _re.findAll();
        System.out.println(1);
    }
}
