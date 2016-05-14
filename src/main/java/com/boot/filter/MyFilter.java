package com.boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

//@Component("myFilter")
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
