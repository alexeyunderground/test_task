package com.zubcov.springboot.myapp.dao;

import com.zubcov.springboot.myapp.entity.Overlord;
import com.zubcov.springboot.myapp.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OverlordDaoImpl implements OverlordDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Overlord> getAllOverlords() {
        Session session = entityManager.unwrap(Session.class);
        List<Overlord> list  = session.createQuery("from Overlord ",Overlord.class).getResultList();
        return list;
    }

    @Override
    public void saveOverlord(Overlord overlord) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(overlord);
    }

    @Override
    public List<Planet> getAllPlanets() {
        Session session = entityManager.unwrap(Session.class);
        List<Planet> list = session.createQuery("from Planet",Planet.class).getResultList();
        return list;
    }

    @Override
    public void savePlanet(Planet planet) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(planet);
    }

    @Override
    public void deletePlanet(Planet planet) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(planet);
    }

    @Override
    public Planet getPlanet(int id) {
        Session session = entityManager.unwrap(Session.class);
        Planet planet = session.get(Planet.class, id);
        return planet;
    }

    @Override
    public List<Overlord> getFreeOverlords() {
        Session session = entityManager.unwrap(Session.class);
        List<Overlord> freeOverlords = session.createQuery("from Overlord",Overlord.class)
                .getResultList()
                .stream()
                .filter(p->p.getPlanetList().size()==0)
                .collect(Collectors.toList());
        return freeOverlords;
    }

    @Override
    public void setOverlordToPlanet(int overlordId, int planetId) {
        Session session = entityManager.unwrap(Session.class);
        Overlord overlord = session.get(Overlord.class,overlordId);
        Planet planet = session.get(Planet.class,planetId);
        overlord.addPlanetToOverlord(planet);
        session.save(overlord);
    }

    @Override
    public List<Overlord> getYoungerOverlords() {
        Session session = entityManager.unwrap(Session.class);
        List<Overlord> overlordList = getAllOverlords();
        Collections.sort(overlordList, new Comparator<Overlord>() {
            @Override
            public int compare(Overlord o1, Overlord o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        List<Overlord> result = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            result.add(overlordList.get(i));
        }
        return result;
    }
}
