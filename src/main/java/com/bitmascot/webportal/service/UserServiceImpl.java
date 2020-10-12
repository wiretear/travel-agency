package com.bitmascot.webportal.service;
import com.bitmascot.webportal.dao.UserDao;
import com.bitmascot.webportal.model.Information;
import com.bitmascot.webportal.model.Location;
import com.bitmascot.webportal.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public List<Users> get( String email) {
         return userDao.get(email);
    }
    @Transactional
    public void save(Users user) {
        userDao.save(user);
    }


    @Transactional
    public List<Users> listPersons() {
        return this.userDao.listPersons();
    }
    public boolean checkLogin(String userName, String userPassword) {
            System.out.println("In Service class...Check Login");
            return userDao.checkLogin(userName, userPassword);
        }

    @Transactional
    public List<Location> getlocation() {
        return this.userDao.location();

    }
}
