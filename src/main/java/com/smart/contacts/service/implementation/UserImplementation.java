package com.smart.contacts.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.contacts.entities.User;
import com.smart.contacts.helper.ResourceNotFoundException;
import com.smart.contacts.repository.UserRepository;
import com.smart.contacts.service.UserService;

@Service
public class UserImplementation implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public User saveUser(User user) {
//		String userId = UUID.randomUUID().toString();
//		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getuserByID(String id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> updateUser(User user) {
		User existingUser = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found with ID: " + user.getUserId()));
		
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		existingUser.setProfilePic(user.getProfilePic());
		existingUser.setAbout(user.getAbout());
		existingUser.setEnabled(user.isEnabled());
		existingUser.setPhoneVerified(user.isPhoneVerified());
		existingUser.setEmailVerified(user.isEmailVerified());
		existingUser.setProvider(user.getProvider());
		existingUser.setProviderUserId(user.getProviderUserId());
		
		userRepository.save(existingUser);
		
		return Optional.ofNullable(existingUser);
	}

	@Override
	public void deleteUser(String id) {
		
		//userRepository.deleteById(id);
		
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found with ID"));
		userRepository.delete(user);
	}

	@Override
	public boolean isUserExist(String id) {
		User user = userRepository.findById(id).orElse(null);
		return user != null ? true : false;
	}


	@Override
	public boolean isUserExistByEmail(String email) {
		User user = userRepository.findByEmail(email).orElse(null);
		return user != null ? true : false;
	}

}
