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

    /**
     *
     * @param person_id
     * @param id
     * @return
     * 首先通过id查询该id的person_id是否与修改后的id相同，
     * 若相同则不作判断，不同则证明更改了身份证号，
     * 需判断是否与其他的person_id相同
     */
    public boolean personIdCheck(String person_id,Integer id){
        Optional<DriverInformation> optional = driverRepository.findById(id);
        DriverInformation driverInformation = optional.get();
        if(!person_id.equals(driverInformation.getPerson_id())){
            if((driverRepository.findByPerson_id(person_id)) != null){
                return false;
            }
            return true;
        }
        return true;
    }
    //方法重载，注册的时候直接判断是否重复。
    public boolean personIdCheck(String person_id){
        if((driverRepository.findByPerson_id(person_id)) != null){
            return false;
        }
        return true;
    }
}

