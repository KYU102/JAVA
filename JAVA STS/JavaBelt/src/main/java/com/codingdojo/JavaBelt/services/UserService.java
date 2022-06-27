package com.codingdojo.JavaBelt.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.JavaBelt.models.LoginUser;
import com.codingdojo.JavaBelt.models.User;
import com.codingdojo.JavaBelt.repos.UserRepo;

@Service
public class UserService {

	// CRUD

	@Autowired
	private UserRepo userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "registerErrors", "This Email is Unavailible");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "registerErrors", "passwaords dont match");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			//HASH PW
			String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPW);
			//SAVE USER TO DB
			return userRepo.save(newUser);
			
		}
	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginErrors", " Email not found");
		}
		else {
			User user = potentialUser.get();
			if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())){
				result.rejectValue("password", "loginErrors", "invalid password");
			}
			if(result.hasErrors()) {
				return null;
			}
			else {
				return user;
			}
		}
		return null;
	}
	
	//FIND ONE
	public User findOne(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		if (potentialUser.isPresent()) {
			return potentialUser.get();
		}
		else {
			return null;
		}
	}
}








