package com.boot.service;

import com.boot.bean.User;
import com.boot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zy on 2016/5/11.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "userCache", key = "'ID_'+T(String).valueOf(#id)")
    public User getUserById(Long id) {
        return userMapper.findUserById(id);
    }

    //@Cacheable(value = "userCache", key = "user.name(#user.name)")
    public User getUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    //@Cacheable(value = "userCache", keyGenerator = "wiselyKeyGenerator")
    public List<User> getAll(User user) {
        PageHelper.startPage(user.getPage(), user.getRows(), "id");
        return userMapper.selectAll();
    }

    @Transactional
    @CachePut(value = "userCache",key = "'ID_'+T(String).valueOf(#user.id)") //Cacheable CachePut 需要返回参数 才可以缓存
    public User addUser(User user){
        userMapper.add(user);
        return user;
    }

    @Transactional
    @CacheEvict(value = "userCache",key = "'ID_'+T(String).valueOf(#user.id)") //使用CacheEvict 别返回数据
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Transactional
    @CacheEvict(value = "userCache",key = "'ID_'+T(String).valueOf(#id)")
    public void deleteUser(Long id){
        userMapper.delete(id);
    }
}
