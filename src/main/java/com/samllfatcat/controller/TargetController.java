package com.samllfatcat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.samllfatcat.exception.MyException;
import com.samllfatcat.pojo.Msg;
import com.samllfatcat.pojo.User;
import com.samllfatcat.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author zsz
 * @Description
 * @date 2022/6/8
 * -------------测试SpringMVC拦截器
 */
@Controller
public class TargetController {

    //测试拦截器
    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行了");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","路飞，海贼王");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    //测试异常处理
    @RequestMapping("/show")
    public String show2() throws MyException, FileNotFoundException {
        System.out.println("show2 running...");
        UserServiceImpl userService = new UserServiceImpl();
        userService.show1();
//        userService.show2();
//        userService.show3();
//        userService.show4();
//        userService.show5();
        return "success";
    }
    //测试异常处理
    @RequestMapping("/get")
    @ResponseBody
    public String show3(){
        Msg msg = new Msg();
        User user = new User();
        user.setUsername("lisi");
        user.setAge(120);
        msg.setCode(1);
        msg.setMsg("OK");
        msg.setData(user);
        System.out.println(msg);
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        String json = JSON.toJSONString(msg, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return json;
    }
    //测试文件上传
    @RequestMapping(value = "/upload1",method = RequestMethod.POST)
    @ResponseBody
    public void show4(String username, MultipartFile uploadFile ) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        //获得文件名称
        String originalFilename = uploadFile.getOriginalFilename();
        //保存文件
        uploadFile.transferTo(new File("/Users/zhushengzhe/Desktop/桌面文件/upload/"+originalFilename));
    }


}
