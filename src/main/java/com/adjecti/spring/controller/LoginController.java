
package com.adjecti.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginPage");
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView LoginView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginPage");
		return mv;
	}

	@RequestMapping(value = "/authfail")
	public ModelAndView Authfail() {
		ModelAndView mv = new ModelAndView();
	//	mv.addObject("");
		
		mv.setViewName("loginPage");
		return mv;
	}
}
