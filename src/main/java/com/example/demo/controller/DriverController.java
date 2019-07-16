package com.example.demo.controller;

import com.example.demo.domain.DriverInformation;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  ZFD
 * Create on 2019/6/28
 */
@Controller
public class DriverController {
    @Autowired
    DriverService driverService;

    @RequestMapping("/getAllDriver")
    @ResponseBody
    public List<DriverInformation> getAllDriver(){
        List<DriverInformation> list = driverService.queryDrivers();
        return list;
    }
    @RequestMapping("/index")
    public String index(){
        return "/view/main";
    }

    /**
     *
     *驾驶员注册或更新
     */
    @RequestMapping(value="/operateDriver",method = RequestMethod.POST)
    @ResponseBody
    public boolean operateDriver(HttpServletRequest req){
        if(driverService.operateDriver(req)){
            return true;
        }
        return false;
    }
    /**
     *驾驶员详情
     *
     */
    @RequestMapping("/getDriverDetails")
    @ResponseBody
    public DriverInformation getDriverDetails(Integer id){
        DriverInformation driverInformation = driverService.queryOneDriver(id);
        return driverInformation;
    }
    /**
     *验证身份证号是否重复
     *
     */
    @RequestMapping("/personIdCheck")
    @ResponseBody
    public boolean personIdCheck(String person_id,Integer id){
        //定义状态变量
        boolean b;
        if(id==null||id.toString()==""){
            b=driverService.personIdCheck(person_id);
        }else{
            b = driverService.personIdCheck(person_id, id);
        }
        return b;
    }

}
