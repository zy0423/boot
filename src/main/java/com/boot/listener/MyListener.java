package com.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

//@Component("myListener")
public class MyListener implements ServletContextListener{  

    public void contextDestroyed(ServletContextEvent arg0) {  
        System.out.println("contextDestroyed...");  
    }  

    public void contextInitialized(ServletContextEvent arg0) {  
        System.out.println("listener contextInitialized...");  
    }  
       
}  