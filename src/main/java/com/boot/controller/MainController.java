package com.boot.controller;

import com.boot.bean.User;
import com.boot.service.PermissionService;
import com.boot.service.RoleService;
import com.boot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * Created by kuye on 2016/5/12.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String main(Model model)
    {
        return "main";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Set<String> roles = roleService.getRolesByUserName(username);
        model.addAttribute("roles", roles);
        return "users";
    }
}
