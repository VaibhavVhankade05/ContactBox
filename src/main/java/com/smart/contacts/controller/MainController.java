package com.smart.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.contacts.entities.User;
import com.smart.contacts.forms.UserForm;
import com.smart.contacts.helper.Message;
import com.smart.contacts.helper.MessageType;
import com.smart.contacts.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @RequestMapping("/service")
    public String servicePage() {
        return "service";
    }

    @RequestMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @RequestMapping(value = "/register/process", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
    	
            // Create a User entity from UserForm
            User user = new User();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            user.setPhoneNumber(userForm.getPhoneNumber());
            user.setAbout(userForm.getAbout());
            user.setProfilePic("/images/defaultProfilePicture.png");

            // Save user using the service
            userService.saveUser(user);

            // Success message
            Message message = Message.builder()
    	    		.content("Resigtred Successfully")
    	    		.type(MessageType.blue)
    	    		.build();
    	    session.setAttribute("message",message);
        
        // Redirect back to the register page
        return "redirect:/register";
    }
}
