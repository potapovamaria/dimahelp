package com.example.main.service;

import com.example.main.entity.Services;
import javassist.NotFoundException;

import javax.management.ServiceNotFoundException;
import java.util.List;

public interface ServicesService {
    List<Services> listServices();
    Services findService(long id) throws ServiceNotFoundException, NotFoundException;
    Services addService(Services services);
    void deleteService(long id);
}
