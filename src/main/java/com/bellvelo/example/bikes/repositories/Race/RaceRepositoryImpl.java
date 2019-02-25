package com.bellvelo.example.bikes.repositories.Race;

import com.bellvelo.example.bikes.models.Race;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class RaceRepositoryImpl implements RaceRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Race> getRacesFromCountry(String country){

        List<Race> results = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Race.class); // sets the base table
            cr.add(Restrictions.eq("country", country)); // returns al riders than age passed in
            results = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }
}
