package com.smart.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.contacts.entities.User;
import com.smart.contacts.forms.UserForm;
import com.smart.contacts.service.UserService;

@Controller
public class MainController 
{
	@Autowired
	private UserService userService;
	
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
	public String registerPage(Model model)
	{
		UserForm userForm = new UserForm();
//		userForm.setName("Vaibhav");
		model.addAttribute("userForm", userForm);
		return "register";
	}
	
	@RequestMapping(value="/register/process", method = RequestMethod.POST)
	public String processregister(@ModelAttribute UserForm userForm) {
	    // Fetch data
		// System.out.println(userForm);

	    // Create the User object directly using constructor
//	    User user = new User();
//	    user.setName(userForm.getName());
//	    user.setEmail(userForm.getEmail());
//	    user.setPassword(userForm.getPassword());
//	    user.setPhoneNumber(userForm.getPhoneNumber());
//	    user.setAbout(userForm.getAbout());
	    
	    
	    User user = User.builder()
	    		.name(userForm.getName())
	    		.email(userForm.getEmail())
                .password(userForm.getPassword())
                .phoneNumber(userForm.getPhoneNumber())
                .about(userForm.getAbout())
                .build();

	    // Save user using the service
	    userService.saveUser(user);

	    // Redirect to register page after saving the user
	    return "redirect:/register";
	}

}
