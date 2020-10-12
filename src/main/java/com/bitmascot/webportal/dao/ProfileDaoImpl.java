package com.bitmascot.webportal.dao;

import com.bitmascot.webportal.model.Information;
import com.bitmascot.webportal.model.Location;
import com.bitmascot.webportal.model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDaoImpl implements ProfileDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void save(Information information) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(information);
    }

    @Override
    public List<Information> listOfProfilePost(String mailid) {

        Session session = this.sessionFactory.getCurrentSession();
        List<Information> personsList = session.createQuery("from Information where mailid = :mailid").
                setParameter("mailid",mailid).list();
        return personsList;
    }

    @Override
    public List<Information> postlist() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Information> postList = session.createQuery("from Information").list();
        return postList;
    }


}

