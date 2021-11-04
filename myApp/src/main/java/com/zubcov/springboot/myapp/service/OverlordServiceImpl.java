package com.zubcov.springboot.myapp.service;

import com.zubcov.springboot.myapp.dao.OverlordDao;
import com.zubcov.springboot.myapp.entity.Overlord;
import com.zubcov.springboot.myapp.entity.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OverlordServiceImpl implements OverlordService{

    @Autowired
    private OverlordDao overlordDao;

    @Override
    @Transactional
    public List<Overlord> getAllOverlords() {
        return overlordDao.getAllOverlords();
    }

    @Override
    @Transactional
    public void saveOverlord(Overlord overlord) {
        overlordDao.saveOverlord(overlord);
    }

    @Override
    @Transactional
    public List<Planet> getAllPlanets() {
        return overlordDao.getAllPlanets();
    }

    @Override
    @Transactional
    public void savePlanet(Planet planet) {
        overlordDao.savePlanet(planet);
    }

    @Override
    @Transactional
    public void deletePlanet(Planet planet) {
        overlordDao.deletePlanet(planet);
    }

    @Override
    @Transactional
    public Planet getPlanet(int id) {
        return overlordDao.getPlanet(id);
    }

    @Override
    @Transactional
    public List<Overlord> getFreeOverlords() {
        return overlordDao.getFreeOverlords();
    }

    @Override
    @Transactional
    public void setOverlordToPlanet(int overlordId, int planetId) {
        overlordDao.setOverlordToPlanet(overlordId,planetId);
    }

    @Override
    @Transactional
    public List<Overlord> getYoungerOverlords() {
        return overlordDao.getYoungerOverlords();
    }
}
