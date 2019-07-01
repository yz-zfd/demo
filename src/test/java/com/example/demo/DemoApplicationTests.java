package com.example.demo;

import com.example.demo.dao.DriverDao;
import com.example.demo.domain.DriverInformation;
import com.example.demo.service.DriverService;
import org.assertj.core.data.Percentage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    DriverService driverService;
    @Autowired
    DriverDao driverDao;

    @Test
    public void getAll(){
        List<DriverInformation> list = driverDao.find();
        for(DriverInformation d:list){
            System.out.println(d);
        }
    }

    /**
     * 用于批量增加数据。
     */
    @Test
    public void contextLoads() {
        int i=0;
        Date date = new Date(new java.util.Date().getTime());
        ArrayList<DriverInformation> list = new ArrayList<>();
        while(i<100){
            //插入部分数据是要自己写sql的
            list.add(new DriverInformation("张山"+i,"中国","13508253588",false,"513022XXXXXXXXX","yz","男","good",date,"本科","c:\\"));
            i++;
        }
        driverDao.saveAll(list);
    }
   /* @Test
    public void connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/yz","root","123456");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from driver_information");
        while(rs.next()){
            System.out.println(rs.getString(0)+rs.getString(1));
        }
    }*/
}
