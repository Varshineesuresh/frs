package com.example.demo.controller;

import com.example.demo.entity.FoodDonation;
import com.example.demo.service.FoodService;
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

    // Request Food
    @PutMapping("/request/{id}")
    public FoodDonation requestFood(@PathVariable Long id) {
        return foodService.requestFood(id);
    }

    // Accept Food Request
    @PutMapping("/accept/{id}")
    public FoodDonation acceptFood(@PathVariable Long id) {
        return foodService.acceptFood(id);
    }

    // Mark Food as Picked Up
    @PutMapping("/pickup/{id}")
    public FoodDonation pickupFood(@PathVariable Long id) {
        return foodService.pickupFood(id);
    }

    // Mark Food as Delivered
    @PutMapping("/deliver/{id}")
    public FoodDonation deliverFood(@PathVariable Long id) {
        return foodService.deliverFood(id);
    }
}