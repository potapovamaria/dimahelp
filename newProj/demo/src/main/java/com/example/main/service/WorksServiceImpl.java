package com.example.main.service;

import com.example.main.entity.Works;
import com.example.main.exception.WorksNotFoundExeption;
import com.example.main.repository.WorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorksServiceImpl implements WorksService{

    @Autowired
    private WorksRepository worksRepository;

    @Override
    public List<Works> listWorks() {
        return (List<Works>) worksRepository.findAll();
    }

    @Override
    public Works findWork(long id) {
        Optional<Works> optionalWorks = worksRepository.findById(id);
        if (optionalWorks.isPresent())
        {
            return optionalWorks.get();
        } else {
            throw new WorksNotFoundExeption("This work not found");
        }
    }

    @Override
    public Works addWork(Works work) {
        return worksRepository.save(work);
    }

    @Override
    public void deleteWork(long id) {
        worksRepository.deleteById(id);
    }
}
