package com.samllfatcat.service;

import com.samllfatcat.exception.MyException;
import com.samllfatcat.pojo.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author zsz
 * @Description
 * @date 2022/6/9
 */
public class UserServiceImpl implements UserService {
    public void show1() {
        System.out.println("抛出类型转换异常...");
        Object str = "zhangsan";
        Integer num = (Integer)str;
    }
    public void show2() {
        System.out.println("抛出0异常...");
        int i = 1/0;
    }

    public void show3() throws FileNotFoundException {
        System.out.println("文件找不到...");
        InputStream in = new FileInputStream("/user/xxx/xxx");
    }

    public void show4() {
        System.out.println("抛出空指针异常...");
        String str = null;
        str.length();
    }
    public void show5() throws MyException {
        System.out.println("自定义异常...");
        throw  new MyException();
    }
}
