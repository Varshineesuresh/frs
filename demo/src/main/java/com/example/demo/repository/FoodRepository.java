
package com.example.demo.repository;

import com.example.demo.entity.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodDonation, Long> {

}