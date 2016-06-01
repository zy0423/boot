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
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String main(Model model)
    {
        return "home";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> userList = userService.getAll(new User());
        model.addAttribute("users", userList);
        return "userList";
    }
}
