package com.boot.controller;


import com.boot.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController
{

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(User user, boolean rememberMe, Model model) {
		String msg = "";

		String userName = user.getName();
		String password = user.getPassword();

		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		//token.setRememberMe(rememberMe);

		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				return "redirect:/main";
			} else {
				return "redirect:/index";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权!";
			model.addAttribute("message", msg);
			System.out.println(msg);
		}
		return "redirect:/index";
	}

	@RequestMapping(value = "/logout")
	public String logout(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, HttpServletRequest request, Model model) {
		SecurityUtils.getSubject().logout();
		return "login";
	}

	private String parseException(HttpServletRequest request) {
		String errorClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

		String msg = null;
		if (UnknownAccountException.class.getName().equals(errorClassName)) {
			msg = "Username or password is incorrect.";
		} else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
			msg = "Username or password is incorrect.";
		} else if (AuthenticationException.class.getName().equals(errorClassName)) {
			msg = "Username or password is incorrect.";
		} else if (DisabledAccountException.class.getName().equals(errorClassName)) {
			msg = "Username or password is incorrect.";
		} else {
			msg = "Username or password is incorrect.";
		}
		return msg;
	}
}
