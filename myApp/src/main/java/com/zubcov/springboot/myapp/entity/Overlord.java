package com.zubcov.springboot.myapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "overlord")
public class Overlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "overlord")
    private List<Planet> planetList;

    public Overlord() {
    }

    public Overlord(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addPlanetToOverlord(Planet planet) {
        if (planetList == null) {
            planetList = new ArrayList<>();
        }
        planet.setOverlord(this);
        planetList.add(planet);
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }

    public void setPlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
