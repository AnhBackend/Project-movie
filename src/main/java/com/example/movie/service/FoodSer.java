package com.example.movie.service;

import com.example.movie.model.Food;
import com.example.movie.model.User;
import com.example.movie.repo.BillFoodRepo;
import com.example.movie.repo.FoodRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FoodSer {
    @Autowired
    FoodRepo foodRepo;
    @Autowired
    BillFoodRepo billFoodRepo;
    public List<Food> getAllFood(){
        return foodRepo.findAll();
    }
    public Food getFoodById(int foodId) {
        return foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found with id: " + foodId));
    }
    public Food addFood(Food food){
        return foodRepo.save(food);
    }
    public Optional<Food> updateFood(int foodId, Food food){
        Optional<Food> optionalFood = foodRepo.findById(foodId);
        if (optionalFood.isPresent()){
            Food food1 = optionalFood.get();
            // Copy các thuộc tính từ updatedFood vào foodToUpdate, giữ nguyên ID
            BeanUtils.copyProperties(food, food1,"id");
            return Optional.of(foodRepo.save(food1));
        }
        else {
            return Optional.empty();
        }
    }
    public boolean deleteFood(int foodId){
        if (foodRepo.existsById(foodId)){
            foodRepo.deleteById(foodId);
            return true;
        }
        return false;
    }
}
