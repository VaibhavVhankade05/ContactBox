package com.smart.contacts.forms;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;


public class UserForm 
{
	@NotBlank(message = "Name is requried")
    private String name;

	@Email(message = "Invalid email address")
	@NotBlank(message = "Email is requried")
    private String email;

	@NotBlank(message = "Password is reqiured")
    private String password;
    
	@NotBlank(message = "About is reqiured")
    private String about;
    
	@NotBlank(message = "Invalid number")
    private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserForm() {
		super();
	}

	public UserForm(String name, String email, String password, String about, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ ", phoneNumber=" + phoneNumber + "]";
	}
    
    
}
    
