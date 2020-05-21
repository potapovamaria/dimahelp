package com.example.main.service;

import com.example.main.entity.Masters;
import com.example.main.entity.Services;
import com.example.main.entity.Works;
import com.example.main.exception.WorksNotFoundExeption;
import com.example.main.repository.MastersRepository;
import com.example.main.repository.WorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MastersServiceImpl implements MastersService{

    @Autowired
    private MastersRepository mastersRepository;

    @Autowired
    private WorksRepository worksRepository;

    @Override
    public List<Masters> listMasters() {
        return (List<Masters>) mastersRepository.findAll();
    }

    @Override
    public Masters findMaster(long id) {
        Optional<Masters> optionalMasters = mastersRepository.findById(id);
        if (optionalMasters.isPresent())
        {
            return optionalMasters.get();
        } else {
            throw new WorksNotFoundExeption("This master not found");
        }
    }

    @Override
    public Masters addMaster(Masters master) {
        return mastersRepository.save(master);
    }

    @Override
    public void deleteMaster(long id) {

        List<Works> works = (List<Works>) worksRepository.findAll();
        for (int i = 0; i < works.size(); i++){
            Works work = works.get(i);
            if (work.getMasters().getId() == id) {
                worksRepository.delete(work);
            }
        }
        mastersRepository.deleteById(id);
    }
}
