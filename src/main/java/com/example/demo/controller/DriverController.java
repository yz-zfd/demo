package com.example.demo.controller;

import com.example.demo.domain.DriverInformation;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

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
    public List<DriverInformation> getAllDriver() {
        return driverService.queryDrivers();
    }

    @RequestMapping("/index")
    public String index() {
        return "/view/main";
    }

    /**
     * 驾驶员注册或更新
     */
    @RequestMapping(value = "/operateDriver", method = RequestMethod.POST)
    @ResponseBody
    public boolean operateDriver(HttpServletRequest req) {
        boolean b = driverService.operateDriver(req);
        return b;
    }

    /**
     * 驾驶员详情
     */
    @RequestMapping("/getDriverDetails")
    @ResponseBody
    public DriverInformation getDriverDetails(Integer id) {
        return driverService.queryOneDriver(id);
    }

    /**
     * 验证身份证号是否重复
     */
    @RequestMapping("/personIdCheck")
    @ResponseBody
    public String personIdCheck(String personId, String phoneNumber, Integer id) {
        //定义状态变量
        String resultOfCheck;
        if (id == null || "".equals(id.toString())) {
            resultOfCheck = driverService.personIdAndPhoneNumberCheck(personId, phoneNumber);
        } else {
            resultOfCheck = driverService.personIdAndPhoneNumberCheck(personId, phoneNumber, id);
        }
        return resultOfCheck;
    }

    //angular
    @RequestMapping(value = "/uploadPhoto",method = RequestMethod.POST)
    @ResponseBody
    public String uploadPhoto(@RequestParam("file") MultipartFile uploadFile) {
        if(uploadFile!=null){
            System.out.println("sss");
        }
        return "ss";
    }
}
