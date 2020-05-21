package com.example.main.service;

import com.example.main.entity.Works;

import java.util.List;

public interface WorksService {
    List<Works> listWorks();
    Works findWork(long id);
    Works addWork(Works work);
    void deleteWork(long id);
}
