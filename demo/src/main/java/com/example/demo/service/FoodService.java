package com.example.demo.service;

import com.example.demo.entity.FoodDonation;
import com.example.demo.entity.FoodStatus;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // Add Food Donation
    public FoodDonation addFood(FoodDonation foodDonation) {
        return foodRepository.save(foodDonation);
    }

    // Get All Food Donations
    public List<FoodDonation> getAllFood() {
        return foodRepository.findAll();
    }

    // Request Food
    public FoodDonation requestFood(Long id) {
        FoodDonation food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food donation not found"));

        if (food.getStatus() != FoodStatus.AVAILABLE) {
            throw new RuntimeException("Food is not available for request");
        }

        food.setStatus(FoodStatus.REQUESTED);

        return foodRepository.save(food);
    }

    // Accept Food Request
    public FoodDonation acceptFood(Long id) {
        FoodDonation food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food donation not found"));

        if (food.getStatus() != FoodStatus.REQUESTED) {
            throw new RuntimeException("Food is not in requested status");
        }

        food.setStatus(FoodStatus.ACCEPTED);

        return foodRepository.save(food);
    }

    // Mark Food as Picked Up
    public FoodDonation pickupFood(Long id) {
        FoodDonation food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food donation not found"));

        if (food.getStatus() != FoodStatus.ACCEPTED) {
            throw new RuntimeException("Food is not accepted yet");
        }

        food.setStatus(FoodStatus.PICKED_UP);

        return foodRepository.save(food);
    }

    // Mark Food as Delivered
    public FoodDonation deliverFood(Long id) {
        FoodDonation food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food donation not found"));

        if (food.getStatus() != FoodStatus.PICKED_UP) {
            throw new RuntimeException("Food has not been picked up yet");
        }

        food.setStatus(FoodStatus.DELIVERED);

        return foodRepository.save(food);
    }
}