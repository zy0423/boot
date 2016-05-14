package com.boot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zy on 2016/5/11.
 */
@Controller
public class DefaultController
{

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping(value = {"/", "/index","/login"},method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @RequestMapping({"/error", "/err"})
    public String err()
    {
        return "error";
    }
}
