package com.example.demo;

import com.example.demo.dao.AuthorityRepository;
import com.example.demo.dao.DriverRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.DriverInformation;
import com.example.demo.domain.UrlRole;
import com.example.demo.service.DriverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    DriverService driverService;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Test
    public void getAll() {
        /*List<DriverInformation> list = driverRepository.find();
        for(DriverInformation d:list){
            System.out.println(d);
        }*/
        /*int[] p={1,5,6,4,6,9};
        int temp;
        for(int i=0;i<5;i++){
            for(int j=i ;j<5;j++){
                if(p[j]>p[j+1]){}{
                    temp=p[j];
                    p[j]=p[j+1];
                    p[i+1]=temp;
                }
            }
                System.out.println(Arrays.toString(p));
    }*/
    }
    /**
     * 用于批量增加数据。
     */
    @Test
    public void contextLoads() throws ParseException {
        int i=0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(new java.util.Date().getTime());
        ArrayList<DriverInformation> list = new ArrayList<>();
        int j=1900;
        while(i<100){
            //插入部分数据是要自己写sql的
            list.add(new DriverInformation("张山山","中国","135"+(j+i)+"3588",false,"513022"+(j+i)+"02016694","yz","男","good",new Date(sdf.parse((j+i)+"-02-01").getTime()+24*3600*1000),"本科","default.png"));
            i++;
        }
        driverRepository.saveAll(list);
    }
    @Test
    public void getUserRoles(){
        List<UrlRole> list = authorityRepository.findAllUrlRoleMapper();
        for (UrlRole str:list) {
            System.out.println(str.getRole());
        }
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
