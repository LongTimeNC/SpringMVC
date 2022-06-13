package com.samllfatcat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.samllfatcat.User;
import com.samllfatcat.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zsz
 * @Description
 * @date 2022/6/8
 * --------------SpringMVC开发步骤
 * --------------1：导入SpringMVC相关坐标
 * --------------2：配置SpringMVC核心控制器DispathcerServlet
 * --------------3：创建controller层和视图界面
 * --------------4：使用注解配置Controller类中业务方法的映射地址
 * --------------5：配置SpringMVC核心文件spring-mvc.xml
 * --------------6：客户端发起请求测试
 *
 */
//controller层bean注解
@Controller
public class UserController {

    //请求映射：用于建立请求URL和处理请求方法之间的对应关系
    //用在类上和方法上都可以
    //返回字符串形式
    @RequestMapping(value = "/save1",method = RequestMethod.GET)
    public String save1(){
        System.out.println("Controller save running...");
        //在Spring-mvc.xml里面手动配置了内部资源解析视图返回直接返回success就可以了
        //直接返回字符串形式
        return "success";
    }

    //页面跳转-返回ModelAndView形式
    @RequestMapping(value = "/save2",method = RequestMethod.GET)
    public ModelAndView save2(){
        //Model：模型，作用：封装数据
        //View：视图，作用：展示数据
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","zhangsan");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //页面跳转-返回ModelAndView形式
    @RequestMapping(value = "/save3",method = RequestMethod.GET)
    public ModelAndView save3(ModelAndView modelAndView){
        //设置模型数据
        modelAndView.addObject("username","lisi");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //页面跳转-返回ModelAndView形式
    @RequestMapping(value = "/save4",method = RequestMethod.GET)
    public String save4(Model model){
        //设置模型数据
        model.addAttribute("username","wangwu");
        return "success";
    }

    //页面跳转-返回HttpServletRequest形式
    @RequestMapping(value = "/save5",method = RequestMethod.GET)
    public String save5(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("username","朱圣哲");
        return "success";
    }

    //回写数据-
    @RequestMapping(value = "/quick1",method = RequestMethod.GET)
    public void quick1(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello World");
    }

    //回写数据-
    @RequestMapping(value = "/quick2",method = RequestMethod.GET)
    //ResponseBody告诉SpringMVC框架 不进行视图跳转 直接进行响应数据
    @ResponseBody
    public String quick2() {
        return "Hello zhu";
    }

    //回写数据-
    @RequestMapping(value = "/quick3",method = RequestMethod.GET)
    //ResponseBody告诉SpringMVC框架 不进行视图跳转 直接进行响应数据
    //返回一个JSON字符串
    @ResponseBody
    public String quick3() {
        User user = new User();
        user.setUsername("zhushengzhe");
        user.setAge(120);
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        String json = JSON.toJSONString(user, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return json;
    }

    //接收数据-普通参数传递
    @RequestMapping(value = "/accept1",method = RequestMethod.GET)
    //ResponseBody告诉SpringMVC框架 不进行视图跳转 直接进行响应数据
    @ResponseBody
    public void accept1(String username,int age) {
        System.out.println(username);
        System.out.println(age);
    }

    //接收数据-pojo封装类型的参数传递
    @RequestMapping(value = "/accept2",method = RequestMethod.GET)
    //ResponseBody告诉SpringMVC 不进行视图跳转 直接进行响应数据
    @ResponseBody
    public void accept2(User user) {
        System.out.println(user);
    }

    //数组类型的参数传递
    @RequestMapping(value = "/accept3",method = RequestMethod.GET)
    @ResponseBody
    public void accept3(String []strings){
        System.out.println(strings);
        System.out.println(Arrays.asList(strings));
    }

    //获取集合类型的参数
    //封装成一个Vo类-成员变量是一个List集合集合里面装的是User类型的对象
    @RequestMapping(value = "/accept4",method = RequestMethod.POST)
    @ResponseBody
    public void accept4(Vo vo){
        System.out.println(vo);
    }

    //获取集合类型的参数
    @RequestMapping(value = "/accept5",method = RequestMethod.POST)
    @ResponseBody
    //接受参数里面的 @RequestBody 代表接受的是JSON对象
    public void accept5(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    //获取普通类型参数
    @RequestMapping(value = "/accept6",method = RequestMethod.GET)
    @ResponseBody
    //RequestParam注解表示当前端传递的参数和接受的参数（username）名称不一样时可以重命名
    //required设置成false代表提交页面的时候不带参数也不会404报错，不一定非要携带参数
    public void accept6(@RequestParam(value = "name",required = false,defaultValue = "samllfatcat") String username){
        System.out.println(username);
    }

    @RequestMapping(value = "/accept7",method = RequestMethod.GET)
    @ResponseBody
    public void accept7(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie);
    }

    
}
