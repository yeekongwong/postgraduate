package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.application.*;
@Controller
public class LoginController {
	private ILoginApp iLoginApp;

	public ILoginApp getiLoginApp() {
		return iLoginApp;
	}
	@Autowired(required=true)
	public void setiLoginApp(ILoginApp iLoginApp) {
		this.iLoginApp = iLoginApp;
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(String name,String pwd,Model model){
		model.addAttribute("message", "name");
		System.out.println(name+"+"+pwd);
		boolean isLogin = iLoginApp.login(name,pwd);
		return isLogin == true?"index":"login";
	}
}
