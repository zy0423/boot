package com.boot.controller;

import com.boot.bean.User;
import com.boot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by kuye on 2016/5/12.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String main(Model model)
    {
        model.addAttribute("subject", SecurityUtils.getSubject());
        return "main";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> users = userService.getAll(new User());
        model.addAttribute("users", users);
        return "users";
    }
}
