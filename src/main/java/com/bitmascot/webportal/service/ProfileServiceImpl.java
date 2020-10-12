package com.bitmascot.webportal.service;

import com.bitmascot.webportal.dao.ProfileDao;
import com.bitmascot.webportal.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileDao profileDao;
     @Transactional
    public void save(Information information) {
         profileDao.save(information);
    }

    @Transactional
    public List<Information> postList() {
          return this.profileDao.postlist();
    }


    @Transactional
    public List<Information> listOfProfilePost(String mailId) {
        return profileDao.listOfProfilePost(mailId);
    }


}
