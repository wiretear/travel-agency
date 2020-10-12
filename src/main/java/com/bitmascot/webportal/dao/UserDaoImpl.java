package com.bitmascot.webportal.dao;



import com.bitmascot.webportal.model.Information;
import com.bitmascot.webportal.model.Location;
import com.bitmascot.webportal.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl  implements UserDao  {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<Users> get(String email) {
        System.out.println("EMAIL"+email);
        Session session = this.sessionFactory.getCurrentSession();
        List users = session
                .createQuery( "from Users where email = :email" )
                .setString( "email", email )
                .list();
        return  users;
    }



    @Override
    public void save(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("Pass"+user.getPassword());
     //   user.setPassword(passwordEncoder.encode(user.getPassword()));
        session.save(user);
    }
    @Override
    public boolean checkLogin(String userName, String userPassword) {
        System.out.println("In Check login");
        Session session = sessionFactory.openSession();
        boolean userFound = false;
        //Query using Hibernate Query Language
        String SQL_QUERY ="from Users  where mailid=? and password=?";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter(0,userName);
        query.setParameter(1,userPassword);
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {
            userFound= true;
        }
        session.close();
        return userFound;
    }
    @Override
    public List<Users> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Users> personsList = session.createQuery("from Users").list();
        return personsList;
    }

    @Override
    public List<Location> location() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Location> locationList = session.createQuery("from Location").list();
        return locationList;
    }

}
