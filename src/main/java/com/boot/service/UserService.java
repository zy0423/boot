package com.boot.service;

import com.boot.bean.User;
import com.boot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zy on 2016/5/11.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
    public User getUserById(Long id, String province, String city)
    {
        System.out.println("初始化 usercache");
        return new User();
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
