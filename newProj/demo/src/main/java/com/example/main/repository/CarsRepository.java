package com.example.main.repository;

import com.example.main.entity.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepository extends CrudRepository<Cars, Long> {
}
