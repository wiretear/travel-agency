package com.bitmascot.webportal.dao;

import com.bitmascot.webportal.model.Information;

import com.bitmascot.webportal.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileDao {
    void save(Information information);
    public List<Information> listOfProfilePost(String mailId);

    public List<Information> postlist();
}
