package com.cyq.spring.boot.blog.controller;

import java.util.ArrayList;
import java.util.List;

import com.cyq.spring.boot.blog.domain.Authority;
import com.cyq.spring.boot.blog.domain.User;
import com.cyq.spring.boot.blog.service.AuthorityService;
import com.cyq.spring.boot.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页控制器.
 */
@Controller
public class MainController {
	private static final Long ROLE_USER_AUTHORITY_ID = 2L;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authorityService;
	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String index() {
		return "redirect:/blogs";
	}
	/**
	 * 获取登录界面
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}

		/**
	 * 注册用户
	 */
	@PostMapping("/register")
	public ModelAndView registerUser(User user) {
		//System.out.println(user);
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
		user.setAuthorities(authorities);
		User user1 = userService.saveUser(user);
		ModelAndView modelAndView;
		if(user1 != null){
			modelAndView = new ModelAndView("auto_jump","model",user1);
			return modelAndView;
		}
		return new ModelAndView("users/register_fail","model",null);
	}

	@RequestMapping("/checkname")
	@ResponseBody
	public int checkname(@RequestParam(value="username") String s) {
		User user = userService.getUserByUsername(s);
		int status = 0;
		System.out.println(user);
		if(user != null){
			//用户名已存在
			status = 1;
		}

		//用户名不存在
		return status;
	}

	@RequestMapping("/checkemail")
	@ResponseBody
	public int checkemail(@RequestParam(value="email") String email) {
		User user = userService.getUserByEmail(email);
		int status = 0;
		System.out.println(user);
		if(user != null){
			//邮箱已被注册
			status = 1;
		}
		//邮箱没有被注册

		return status;
	}
	
	@GetMapping("/search")
	public String search() {
		return "search";
	}
}
