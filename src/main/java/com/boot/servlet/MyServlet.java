package com.boot.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

//@Component("myServlet")
public class MyServlet implements Servlet
{

	public void destroy()
	{
		System.out.println("destroy...");
	}


	public ServletConfig getServletConfig()
	{
		return null;
	}


	public String getServletInfo()
	{
		return null;
	}


	public void init(ServletConfig arg0) throws ServletException
	{
		System.out.println("servlet init...");
	}


	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException
	{
		System.out.println("service...");
	}

}
