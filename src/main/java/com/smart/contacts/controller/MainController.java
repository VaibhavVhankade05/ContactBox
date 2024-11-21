package com.smart.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController 
{
	
	@RequestMapping("/")
	public String index()
	{
		return "home";
	}
	
	
	@RequestMapping("/home") 
	public String homePage(Model model)
	{
//		model.addAttribute("title", "About - ContactBox");
		return "home";
	}
	
	
	@RequestMapping("/about")
    public String aboutPage(Model model) {
//        model.addAttribute("title", "About - ContactBox");
        return "about";
    }
	
	
	@RequestMapping("/service")
	public String servicePage()
	{
		return "service";
	}
	
	
	@RequestMapping("/contact")
	public String contactPage()
	{
		return "contact";
	}
	
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	
	@RequestMapping("/register")
	public String registerPage()
	{
		return "register";
	}

}
