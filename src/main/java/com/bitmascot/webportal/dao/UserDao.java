package com.bitmascot.webportal.dao;


import com.bitmascot.webportal.model.Information;
import com.bitmascot.webportal.model.Location;
import com.bitmascot.webportal.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    List<Users> get( String email);
    void save(Users user);
    public boolean checkLogin(String userName, String userPassword);
    public List<Users> listPersons();
    public List<Location> location();
}
