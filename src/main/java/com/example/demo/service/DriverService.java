package com.example.demo.service;

import com.example.demo.dao.DriverRepository;
import com.example.demo.domain.DriverInformation;
import com.example.demo.util.DriverManageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 或取全部驾驶员的信息
     * @return 返回驾驶员对象集合
     */
    public List<DriverInformation> queryDrivers(){
        return driverRepository.find();
    }

    /**
     * 用于将表单数据封装到driver对象中，并保存图片到文件系统中
     * @param request HttpServletRequest请求对象
     * @return 返回boolean
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean operateDriver(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>(request.getContentLength());
        DriverInformation driver = new DriverInformation();
        try {
            DriverManageUtil.parseFileFormUtil(map,request);
            BeanUtils.populate(driver,map);
            //针对于不修改图片做判断是注册还是登陆，可用复杂的sql更新(set)语句替代
            //这是封装工具会自动将null的Integer封装成0；
            if(driver.getPhoto()==null && driver.getId()!=null && driver.getId()!=0){
                Optional<DriverInformation> optional = driverRepository.findById(driver.getId());
                driver.setPhoto(optional.get().getPhoto());
            }else if (driver.getPhoto()==null && driver.getId()==0){
                driver.setPhoto("default.png");
            }
            driverRepository.save(driver);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 查询一个驾驶员的全部信息
     * @param id 驾驶员id
     * @return 返回DriverInformation对象
     */
    public DriverInformation queryOneDriver(Integer id){
        Optional<DriverInformation> driverInformation=driverRepository.findById(id);
        return driverInformation.get();
    }

    /**
     *
     * @param personId 身份证号
     * @param id id号
     * @return 返回boolean
     * 首先通过id查询该id的person_id是否与修改后的person_id相同，
     * 若相同则不作判断，不同则证明更改了身份证号，
     * 需判断是否与其他的person_id相同
     */
    public String personIdAndPhoneNumberCheck(String personId,String phoneNumber,Integer id){
        Optional<DriverInformation> optional = driverRepository.findById(id);
        DriverInformation driverInformation = optional.get();
        /*
        if逻辑梳理：
            1.首先判断是否都与原id的值都相同，相同则不管
            2.不都同：则找出相同的那一个，判断不同的那个是否重复
            3.最后若是都不同：则直接调用注册时的判断逻辑
        */
        if (personId.equals(driverInformation.getPerson_id()) && phoneNumber.equals(driverInformation.getPhone_number())){
            return "true";
        }
        if (personId.equals(driverInformation.getPerson_id())){
            if (driverRepository.findByPhoneNumber(phoneNumber)!=null){
                return "phoneNumber";
            }
            return "true";
        }
        if (phoneNumber.equals(driverInformation.getPhone_number())){
            if (driverRepository.findByPersonId(personId)!=null){
                return "personId";
            }
            return "true";
        }
        return personIdAndPhoneNumberCheck(personId,phoneNumber);
    }

    /**
     * 重载方法，用于区分注册与更改。
     * @param personId 用户身份证号
     * @return 返回的boolean值用户判断是否重复
     */
    public String personIdAndPhoneNumberCheck(String personId,String phoneNumber){
        if (driverRepository.findByPhoneNumber(phoneNumber)!=null){
            return "phoneNumber";
        }
        if((driverRepository.findByPersonId(personId)) != null){
            return "personId";
        }
        return "true";
    }
}

