package com.springmvc.controller;


import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {
	@RequestMapping(value="/HelloWorld",method = RequestMethod.GET)
	public String HelloWorld(Model model){
		model.addAttribute("message","Hello World!!!");		
		System.out.println("HelloWorld already action");
		return "HelloWorld";
	}
	@Test
	public void test(){
		System.out.println("test");
	}
		
}


