package com.example.main.entity;

import lombok.Data;

@Data
public class WorkDto {

    private String date_work;

    private Long carId;

    private Long serviceId;

    private Long masterId;


    public String getDate() {
        return date_work;
    }

    public Long getCarId() {
        return carId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setDate(String date) {
        this.date_work = date;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }
}