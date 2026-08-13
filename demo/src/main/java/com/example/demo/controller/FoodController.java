package com.example.demo.controller;

import com.example.demo.entity.FoodDonation;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // Add Food Donation
    @PostMapping("/add")
    public FoodDonation addFood(@RequestBody FoodDonation foodDonation) {
        return foodService.addFood(foodDonation);
    }

    // Get All Food Donations
    @GetMapping
    public List<FoodDonation> getAllFood() {
        return foodService.getAllFood();
    }
}