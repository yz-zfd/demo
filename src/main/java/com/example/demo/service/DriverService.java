package com.example.demo.service;

import com.example.demo.dao.DriverRepository;
import com.example.demo.domain.DriverInformation;
import com.example.demo.util.DriverManageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author zfd
 *
 */
@Service

public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public List<DriverInformation> queryDrivers(){
        List<DriverInformation> list = driverRepository.find();
        return list;
    }

    /**
     * 用于将表单数据封装到driver对象中，并保存图片到文件系统中
     * @param request
     * @return i
     */
    @Transactional
    public boolean operateDriver(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        DriverInformation driver = new DriverInformation();
        try {
            DriverManageUtil.parseFileFormUtil(map,request);
            BeanUtils.populate(driver,map);
            driverRepository.save(driver);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //查询一个司机
    public DriverInformation queryOneDriver(Integer id){
        Optional<DriverInformation> driverInformation=driverRepository.findById(id);
        return driverInformation.get();
    }
    //验证身份证号
    public boolean personIdCheck(Integer person_id){
        if((driverRepository.findByPerson_id(person_id)) != null)
            return false;
        return true;
    }
}

