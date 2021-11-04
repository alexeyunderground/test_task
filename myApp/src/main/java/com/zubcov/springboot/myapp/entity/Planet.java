package com.zubcov.springboot.myapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Overlord overlord;

    public Planet() {
    }

    public Planet(String name) {
        this.name = name;
    }

    public Overlord getOverlord() {
        return overlord;
    }

    public void setOverlord(Overlord overlord) {
        this.overlord = overlord;
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

}
