package com.example.demo.service;

import com.example.demo.entity.FoodDonation;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodDonation addFood(FoodDonation foodDonation) {
        return foodRepository.save(foodDonation);
    }

    public List<FoodDonation> getAllFood() {
        return foodRepository.findAll();
    }
}