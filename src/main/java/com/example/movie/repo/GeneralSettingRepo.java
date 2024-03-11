package com.example.movie.repo;

import com.example.movie.model.GeneralSetting;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GeneralSettingRepo extends JpaRepository<GeneralSetting,Integer> {
}
