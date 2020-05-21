package com.example.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "masters")
public class Masters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    public Masters() {
    }

    public Masters(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Masters{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

