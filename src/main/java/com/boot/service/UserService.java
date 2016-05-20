package com.boot.service;

import com.boot.bean.Address;
import com.boot.bean.User;
import com.boot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zy on 2016/5/11.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
    public User getUserById(Long id, String province, String city)
    {
        System.out.println("usercache 缓存初始化");
        return new User();
    }

    @Cacheable(value = "addresscache", keyGenerator = "wiselyKeyGenerator")
    public Address findAddress(Long id, String province, String city) {
        System.out.println("无缓存的时候调用这里");
        return new Address(id, province, city);
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
