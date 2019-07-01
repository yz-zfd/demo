package com.example.demo.service;

import com.example.demo.dao.DriverDao;
import com.example.demo.domain.DriverInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    DriverDao driverDao;
    public List<DriverInformation> queryDrivers(){
        List<DriverInformation> list = driverDao.find();
        return list;
    }
    public int addDrivers(){
        return 0;
    }
}

