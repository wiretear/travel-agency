package com.bitmascot.webportal.service;

import com.bitmascot.webportal.model.Information;

import java.util.List;


public interface ProfileService {
    void save(Information information);
    public List<Information> postList();
    public List<Information> listOfProfilePost(String mailId);
}
