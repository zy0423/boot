package com.boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

//@WebFilter //多个filter执行顺序可以通过类名控制(例.Filter_01、Filter_02、Filter_03)
public class MyFilter implements Filter
{

	public void destroy()
	{
		System.out.println("destroy...");
	}


	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException
	{
		System.out.println("doFilter...");
		arg2.doFilter(arg0, arg1);
	}


	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("filter init...");
	}

}
