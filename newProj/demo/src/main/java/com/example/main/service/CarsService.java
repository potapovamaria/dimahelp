package com.example.main.service;

import com.example.main.entity.Cars;
import com.example.main.entity.Works;

import java.util.List;

public interface CarsService {
    List<Cars> listCars();
    Cars findCar(long id);
    Cars addCar(Cars cars);
    void deleteCar(long id);
}
