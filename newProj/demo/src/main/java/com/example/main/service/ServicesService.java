package com.example.main.service;

import com.example.main.entity.Services;
import com.example.main.entity.Works;

import java.util.List;

public interface ServicesService {
    List<Services> listServices();
    Services findService(long id);
    Services addService(Services services);
    void deleteService(long id);
}
