package com.example.demo.service;

import com.example.demo.dao.DriverDao;
import com.example.demo.domain.DriverInformation;
import com.example.demo.util.DriverManageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zfd
 *
 */
@Service
public class DriverService {
    @Autowired
    DriverDao driverDao;
    public List<DriverInformation> queryDrivers(){
        List<DriverInformation> list = driverDao.find();
        return list;
    }

    /**
     * 用于将表单数据封装到driver对象中，并保存图片到文件系统中
     * @param request
     * @return i
     */
    public int operateDriver(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        DriverInformation driver = new DriverInformation();
        try {
            DriverManageUtil.parseFileFormUtil(map,request);
            BeanUtils.populate(driver,map);
            if(driver.getId()!=0 && driver.getId()!=null){
                //id为0，为注册
            }else{
                //id为1，为更新
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    //修改驾驶员信息
    public int updateDrivers(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        DriverInformation driver = new DriverInformation();
        try {
            DriverManageUtil.parseFileFormUtil(map,request);
            BeanUtils.populate(driver,map);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}

