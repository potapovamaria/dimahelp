package com.example.main.service;

import com.example.main.entity.Masters;
import com.example.main.entity.Works;

import java.util.List;

public interface MastersService {
    List<Masters> listMasters();
    Masters findMaster(long id);
    Masters addMaster(Masters master);
    void deleteMaster(long id);
}
