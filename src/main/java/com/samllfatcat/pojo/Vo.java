package com.samllfatcat.pojo;

import com.samllfatcat.User;

import java.util.List;

/**
 * @author zsz
 * @Description
 * @date 2022/6/12
 */
public class Vo {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "userList=" + userList +
                '}';
    }
}
