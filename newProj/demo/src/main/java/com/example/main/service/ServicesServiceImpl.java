package com.example.main.service;

import com.example.main.entity.Services;
import com.example.main.entity.Works;
import com.example.main.exception.WorksNotFoundExeption;
import com.example.main.repository.ServicesRepository;
import com.example.main.repository.WorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesServiceImpl implements ServicesService{

    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private WorksRepository worksRepository;

    @Override
    public List<Services> listServices() {
        return (List<Services>) servicesRepository.findAll();
    }

    @Override
    public Services findService(long id) {
        Optional<Services> optionalServices = servicesRepository.findById(id);
        if (optionalServices.isPresent())
        {
            return optionalServices.get();
        } else {
            throw new WorksNotFoundExeption("This service not found");
        }
    }

    @Override
    public Services addService(Services service) {
        return servicesRepository.save(service);
    }

    @Override
    public void deleteService(long id) {
        List<Works> works = (List<Works>) worksRepository.findAll();
        for (int i = 0; i < works.size(); i++){
            Works work = works.get(i);
            if (work.getServices().getId() == id) {
                worksRepository.delete(work);
            }
        }
        servicesRepository.deleteById(id);
    }
}
