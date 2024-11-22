package com.smart.contacts.service;

import java.util.List;
import java.util.Optional;

import com.smart.contacts.entities.User;

public interface UserService 
{
	User saveUser(User user); 
	
	Optional<User> getuserByID(String id);
	
	List<User> getAllUsers();
	
	Optional<User> updateUser(User user);
	
	void deleteUser(String id);
	
	boolean isUserExist(String id);
	
	boolean isUserExistByEmail(String email);

}
