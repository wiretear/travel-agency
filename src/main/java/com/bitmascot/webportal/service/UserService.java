package com.bitmascot.webportal.service;

import com.bitmascot.webportal.model.Information;
import com.bitmascot.webportal.model.Location;
import com.bitmascot.webportal.model.Users;


import java.util.List;

public interface UserService
{
    List<Users> get(String email);
    void save(Users user);

    public List<Users> listPersons();


     public boolean checkLogin(String userName, String userPassword);
    List<Location> getlocation();
}
