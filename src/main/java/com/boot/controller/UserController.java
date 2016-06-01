package com.boot.controller;

import com.boot.bean.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zy on 2016/6/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String main(Model model, @PathVariable Long id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Model model,User user){
        userService.updateUser(user);
        return "redirect:/home/users";
    }
}
