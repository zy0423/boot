package com.boot.service;

import com.boot.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by zy on 2016/5/12.
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Cacheable(value = "rolecache", keyGenerator = "wiselyKeyGenerator")
    public Set<String> getRolesByUserName(String username) {
        System.out.println("初始化 rolecache");
        return roleMapper.findRoles(username);
    }
}
