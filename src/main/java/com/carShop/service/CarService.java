package com.carShop.service;

import com.carShop.model.Car;
import com.carShop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    //READ
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public List<Car> findAllCarsByBrand(String brand) {
        return carRepository.findAllCarsByBrand(brand);
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    public List<Car> getAllCarsByBrandAndModel(String brand, String model) {
        return carRepository.findAllCarsByBrandAndModel(brand, model);
    }

    public List<Car> getAllCarsByBrandModelAndColor(String brand, String model, String color) {
        return carRepository.findAllCarsByBrandAndModelAndColor(brand, model, color);
    }

    public List<Car> getAllCarsByEngineModel(String engineModel) {
        return carRepository.findAllCarsByEngineModel(engineModel);
    }

    public List<Car> getAllCarsPrice(double price) {
        return carRepository.getAllCarsByPrice(price);

    }

    //SAVE
    public Car addNewCar(Car car) {
        return carRepository.save(car);
    }

    //EDIT
    public Car editCar(Car car) {
        return carRepository.save(car);
    }

    //DELETE

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }


}
