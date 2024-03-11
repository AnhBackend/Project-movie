package com.example.movie.repo;

import com.example.movie.model.Banners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepo extends JpaRepository<Banners, Integer> {
}
