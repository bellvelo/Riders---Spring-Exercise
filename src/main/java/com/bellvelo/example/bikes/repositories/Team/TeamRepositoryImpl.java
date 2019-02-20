package com.bellvelo.example.bikes.repositories.Team;


import com.bellvelo.example.bikes.models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class TeamRepositoryImpl implements TeamRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Team> getTeamsByNation(String nationality){

        Session session = entityManager.unwrap(Session.class);
        List<Team> results  = null;

        try{
            Criteria cr = session.createCriteria(Team.class);
            cr.add(Restrictions.eq("nationality", nationality));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }
}
