package com.zubcov.springboot.myapp.service;

import com.zubcov.springboot.myapp.entity.Overlord;
import com.zubcov.springboot.myapp.entity.Planet;

import java.util.List;

public interface OverlordService {
    public List<Overlord> getAllOverlords();
    public void saveOverlord(Overlord overlord);
    public List<Planet> getAllPlanets();
    public void savePlanet(Planet planet);
    public void deletePlanet(Planet planet);
    public Planet getPlanet(int id);
    public List<Overlord> getFreeOverlords();
    public void setOverlordToPlanet(int overlordId,int planetId);
    public List<Overlord> getYoungerOverlords();
}
