package com.boot.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandleController implements ErrorController
{
	/**
	 * @return
	 * @see ErrorController#getErrorPath()
	 */
	public String getErrorPath()
	{
		return "error";
	}

	@RequestMapping
	public String errorHandle()
	{
		return getErrorPath();
	}
}
