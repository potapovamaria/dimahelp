package com.example.main.service;

import com.example.main.entity.Cars;
import com.example.main.entity.Services;
import com.example.main.entity.Works;
import com.example.main.exception.WorksNotFoundExeption;
import com.example.main.repository.CarsRepository;
import com.example.main.repository.WorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService{

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private WorksRepository worksRepository;

    @Override
    public List<Cars> listCars() {
        return (List<Cars>) carsRepository.findAll();
    }

    @Override
    public Cars findCar(long id) {
        Optional<Cars> optionalCars = carsRepository.findById(id);
        if (optionalCars.isPresent())
        {
            return optionalCars.get();
        } else {
            throw new WorksNotFoundExeption("This car not found");
        }
    }

    @Override
    public Cars addCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {

        List<Works> works = (List<Works>) worksRepository.findAll();
        for (int i = 0; i < works.size(); i++){
            Works work = works.get(i);
            if (work.getCars().getId() == id) {
                worksRepository.delete(work);
            }
        }
        carsRepository.deleteById(id);
    }
}
