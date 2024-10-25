package com.example.car.rental;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CarController {

    private List<Car> cars = new ArrayList<>();

    public CarController() {
        // Initialisation des voitures
        cars.add(new Car("11AA22", "Ferrari", 100, false));
        cars.add(new Car("33BB44", "Toyota", 50, false));
    }

    // Liste des voitures non louées
    @GetMapping("/cars")
    @ResponseBody
    public List<Car> listOfCars() {
        List<Car> unrentedCars = new ArrayList<>();
        for (Car car : cars) {
            if (!car.isRented()) {
                unrentedCars.add(car);
            }
        }
        return unrentedCars;
    }

    // Détails d'une voiture par plaque
    @GetMapping("/cars/{plateNumber}")
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElseThrow(() -> new Exception("Car not found"));
    }

    // Louer ou rendre une voiture
    @PutMapping("/cars/{plateNumber}")
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam("rent") boolean rent,
            @RequestBody(required = false) Dates dates) throws Exception {
        Car car = cars.stream()
                .filter(c -> c.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElseThrow(() -> new Exception("Car not found"));
        car.setRented(rent);
        if (rent) {
            System.out.println("Car rented from " + dates.getBegin() + " to " + dates.getEnd());
        } else {
            System.out.println("Car returned");
        }
    }
}
