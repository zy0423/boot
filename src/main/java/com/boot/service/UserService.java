package com.boot.service;

import com.boot.bean.User;
import com.boot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zy on 2016/5/11.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id)
    {
        return userMapper.findUserById(id);
    }

    public User getUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    public List<User> getAll(User user) {
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows(), "id");
        }
        return userMapper.selectAll();
    }
}
