package com.boot.service;

import com.boot.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by zy on 2016/5/12.
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Cacheable(value = "permissioncache", keyGenerator = "wiselyKeyGenerator")
    public Set<String> getPermissionsByUserName(String username) {
        System.out.println("permissioncache 缓存初始化");
        return permissionMapper.findPermissions(username);
    }
}
