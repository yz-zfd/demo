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

    //驾驶员注册
    @RequestMapping(value="/operateDriver",method = RequestMethod.POST)
    @ResponseBody
    public boolean operateDriver(HttpServletRequest req){
        driverService.operateDriver(req);
        return true;
    }

}
