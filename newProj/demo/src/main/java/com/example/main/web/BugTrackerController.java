package com.example.main.web;

import com.example.main.entity.Cars;
import com.example.main.entity.Masters;
import com.example.main.entity.Services;
import com.example.main.entity.Works;
import com.example.main.exception.WorksNotFoundExeption;
import com.example.main.service.CarsService;
import com.example.main.service.MastersService;
import com.example.main.service.ServicesService;
import com.example.main.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/bt")
public class BugTrackerController {

    private WorksService worksService;
    private CarsService carsService;
    private MastersService mastersService;
    private ServicesService servicesService;

    @RequestMapping(
            value = "/*",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Component("/*")
    public static class myFilter implements Filter {
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletResponse hsr = (HttpServletResponse) servletResponse;
            hsr.setHeader("Access-Control-Allow-Origin", "*");
            hsr.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            hsr.setHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @PostMapping(value = "/addWork", consumes = "application/json", produces = "application/json")
    public Works addWork(@RequestBody Works newWork) {
        return worksService.addWork(newWork);
    }

    @PostMapping(value = "/addCar", consumes = "application/json", produces = "application/json")
    public Cars addCar(@RequestBody Cars newCar) {
        return carsService.addCar(newCar);
    }

    @PostMapping(value = "/addMaster", consumes = "application/json", produces = "application/json")
    public Masters addMaster(@RequestBody Masters newMaster) {
        return mastersService.addMaster(newMaster);
    }

    @PostMapping(value = "/addService", consumes = "application/json", produces = "application/json")
    public Services addService(@RequestBody Services newService) {
        return servicesService.addService(newService);
    }

    @GetMapping("/works")
    public ResponseEntity<List<Works>> getAllWorks() {
        List<Works> list = worksService.listWorks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/masters")
    public ResponseEntity<List<Masters>> getAllMasters() {
        List<Masters> list = mastersService.listMasters();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/cars")
    public ResponseEntity<List<Cars>> getAllCars() {
        List<Cars> list = carsService.listCars();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/services")
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> list = servicesService.listServices();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/works/{id}")
    public ResponseEntity<Works> getWork(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(worksService.findWork(id), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This work not found");
        }
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Cars> getCar(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(carsService.findCar(id), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This car not found");
        }
    }

    @GetMapping("/masters/{id}")
    public ResponseEntity<Masters> getMaster(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(mastersService.findMaster(id), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This master not found");
        }
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Services> getService(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(servicesService.findService(id), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This service not found");
        }
    }


    @PostMapping("/delete/cars/{id}")
    public ResponseEntity<List<Cars>> deleteCar(@PathVariable("id") long id) {
        try {
            carsService.deleteCar(id);
            return new ResponseEntity<>(carsService.listCars(), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This car not found");
        }
    }

    @PostMapping("/delete/masters/{id}")
    public ResponseEntity<List<Masters>> deleteMaster(@PathVariable("id") long id) {
        try {
            mastersService.deleteMaster(id);
            return new ResponseEntity<>(mastersService.listMasters(), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This master not found");
        }
    }

    @PostMapping("/delete/services/{id}")
    public ResponseEntity<List<Services>> deleteService(@PathVariable("id") long id) {
        try {
            servicesService.deleteService(id);
            return new ResponseEntity<>(servicesService.listServices(), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This service not found or delete mistake");
        }
    }

    @PostMapping("/delete/works/{id}")
    public ResponseEntity<List<Works>> deleteWorks(@PathVariable("id") long id) {
        try {
            worksService.deleteWork(id);
            return new ResponseEntity<>(worksService.listWorks(), HttpStatus.OK);
        }catch (WorksNotFoundExeption ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This work not found or delete mistake");
        }
    }

    @Autowired
    public void setWorksService(WorksService worksService) {
        this.worksService = worksService;
    }
    @Autowired
    public void setCarsService(CarsService carsService) {
        this.carsService = carsService;
    }
    @Autowired
    public void setMastersService(MastersService mastersService) {
        this.mastersService = mastersService;
    }
    @Autowired
    public void setServicesService(ServicesService servicesService) {
        this.servicesService = servicesService;
    }
}
