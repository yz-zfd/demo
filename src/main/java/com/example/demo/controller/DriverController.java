package com.example.demo.controller;

import com.example.demo.domain.DriverInformation;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @RequestMapping("/registerDriver")
    @ResponseBody
    public boolean registerDriver(HttpServletRequest req){
        driverService.addDrivers(req);
        return true;
    }
}
