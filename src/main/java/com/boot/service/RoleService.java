package com.boot.service;

import com.boot.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by zy on 2016/5/12.
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public Set<String> getRolesByUserName(String username) {
        return roleMapper.findRoles(username);
    }
}
