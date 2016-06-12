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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String main(Model model, HttpServletRequest request, HttpServletResponse response)
    {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String remoteAddress=request.getRemoteAddr();
        String servletPath=request.getServletPath();
        String realPath=request.getRealPath("/");
        String remoteUser=request.getRemoteUser();
        String requestURI=request.getRequestURI();
        System.out.println("path:"+path+"<br>");
        System.out.println("basePath:"+basePath+"<br>");
        System.out.println("remoteAddr:"+remoteAddress+"<br>");
        System.out.println("servletPath:"+servletPath+"<br>");
        System.out.println("realPath:"+realPath+"<br>");
        System.out.println("remoteUser:"+remoteUser+"<br>");
        System.out.println("requestURI:"+requestURI+"<br>");
        return "sys/index";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> userList = userService.getAll(new User());
        model.addAttribute("users", userList);
        return "userList";
    }

    @RequestMapping("/grid")
    public String grid(Model model) {
        return "sys/grid";
    }
}
