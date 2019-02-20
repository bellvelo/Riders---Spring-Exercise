package com.bellvelo.example.bikes.repositories.Rider;

import com.bellvelo.example.bikes.models.Rider;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class RiderRepositoryImpl implements RiderRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Rider> getRidersOverAge(int age){

        List<Rider> results = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Rider.class); // sets the base table
            cr.add(Restrictions.gt("age", age)); // returns al riders than age passed in
            results = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }

}
