package com.carShop.repository;

import com.carShop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllCarsByBrand(String brand);
    List<Car> findAllCarsByBrandAndModel(String brand, String model);
    List<Car> findAllCarsByBrandAndModelAndColor(String brand, String model, String color);
    List<Car> findAllCarsByEngineModel(String engineModel);

    List<Car> getAllCarsByPrice(double price);


}
