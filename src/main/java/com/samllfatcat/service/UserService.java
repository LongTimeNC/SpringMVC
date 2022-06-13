package com.samllfatcat.pojo;

import com.samllfatcat.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @author zsz
 * @Description
 * @date 2022/6/9
 */
public interface UserService {
    public void show1();
    public void show2();
    public void show3() throws FileNotFoundException;
    public void show4() throws FileNotFoundException;
    public void show5() throws MyException;
}
