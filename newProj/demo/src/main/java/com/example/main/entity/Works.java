package com.example.main.entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "works")
public class Works {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    private String date_work;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "master_id")
    private Masters masters;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Cars cars;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Services services;

    public Works() {
    }

    public Works(String date_work, Masters masters, Services services, Cars cars) {
        this.date_work = date_work;
        this.cars = cars;
        this.masters = masters;
        this.services = services;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public Masters getMasters() {
        return masters;
    }

    public Services getServices() {
        return services;
    }

    public void setMasters(Masters masters) {
        this.masters = masters;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Long getId() {
        return Id;
    }

    public String getDate_work() {
        return date_work;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setDate_work(String date_work) {
        this.date_work = date_work;
    }

    @Override
    public String toString() {
        return "Works{" +
                "Id=" + Id +
                ", date_work='" + date_work + '\'' +
                ", masters=" + masters +
                ", cars=" + cars +
                ", services=" + services +
                '}';
    }
}
