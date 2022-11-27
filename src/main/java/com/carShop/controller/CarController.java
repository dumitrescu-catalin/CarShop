package com.carShop.controller;


import com.carShop.exception.ResourceNotFoundException;
import com.carShop.model.Car;
import com.carShop.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")     //localhost:8080/api/cars
public class CarController {

    private final CarService carService;

    //GET
    @GetMapping("/allCars")              //localhost:8080/api/cars/allCars
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = carService.findAllCars();
        if (carList.size() == 0) {
            throw new ResourceNotFoundException("There are no car in the database");
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/getCarById/{id}")   //localhost:8080/api/cars/getCarById/
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        Car car = carService.getCarById(id).orElseThrow(() -> new ResourceNotFoundException("Car with id: " + id + " not found in DB!"));
        return ResponseEntity.ok(car);
    }

    @GetMapping("/getCarsByBrand/{brand}")      //localhost:8080/api/cars/getCarsByBrand/
    public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable String brand) {
        List<Car> carList = carService.findAllCarsByBrand(brand);
        if (carList.size() == 0) {
            throw new ResourceNotFoundException("Cars with brand: " + brand + " not found in DB!");
        }
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/getAllCarsByBrandAndModel/{brand}/{model}")  //localhost:8080/api/cars/getAllCarsByBrandAndModel/
    public ResponseEntity<List<Car>> getCarsByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        List<Car> carList = carService.getAllCarsByBrandAndModel(brand, model);
        if (carList.size() == 0) {
            throw new ResourceNotFoundException("Cars with brand and model: " + brand + ", " + model + " not found in DB!");
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/getAllCarsByBrandModelAndColor/{brand}/{model}/{color}")  //localhost:8080/api/cars/getAllCarsByBrandModelAndColor/
    public ResponseEntity<List<Car>> getCarsByBrandModelAndColor(@PathVariable String brand, @PathVariable String model, @PathVariable String color) {
        List<Car> carList = carService.getAllCarsByBrandModelAndColor(brand, model, color);
        if (carList.size() == 0) {
            throw new ResourceNotFoundException("Cars with brand, model, color: " + brand + ", " + model + ", " + color + " not found in DB!");
        }
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/getAllCarsByEngineModel/{engineModel}")   //localhost:8080/api/cars/getAllCarsByEngineModel/
    public ResponseEntity<List<Car>> getCarsByEngineModel(@PathVariable String engineModel) {
        List<Car> carList = carService.getAllCarsByEngineModel(engineModel);
        if (carList.size() == 0) {
            throw new ResourceNotFoundException("Cars with engine model: " + engineModel + " not found in DB!");
        }
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/getCarsByPrice/{price}")      //localhost:8080/api/cars/getCarsByPrice/
    public ResponseEntity<List<Car>> getCarsByPrice(@PathVariable double price) {
        List<Car> carList = carService.getAllCarsPrice(price);
        if (carList.size() == 0) {
            throw new ResourceNotFoundException("Cars with brand: " + price + " not found in DB!");
        }
        return ResponseEntity.ok(carList);
    }

    //POST
    @PostMapping("/addNewCar")          //localhost:8080/api/cars/addNewCar
    public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
        Car newCar = carService.addNewCar(car);
        return ResponseEntity.ok(newCar);
    }

    //PUT
    @PutMapping("/updateCar")       //localhost:8080/api/cars/updateCar
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car editCar = carService.editCar(car);
        return ResponseEntity.ok(editCar);
    }

    //DELETE
    @DeleteMapping("/deleteCar/{id}")    //localhost:8080/api/cars/deleteCar/
    public ResponseEntity<?> deleteProd(@PathVariable int id) {
        carService.getCarById(id).orElseThrow(() -> new ResourceNotFoundException("Car with id: " + id + " not found in DB"));
        carService.deleteCarById(id);
        return ResponseEntity.ok("Car with id: " + id + " deleted successfully!");
    }


}
