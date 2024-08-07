package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movieflix.entities.User;
import com.movieflix.repositories.UserRepo;



@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepo urepo;
	
	@Override
	public String addUsers(User usr) {
		urepo.save(usr);
		return "user is created";
	}
	
	
	public boolean emailExits(String email)  {
		//checking whether the user exist with entered email
		if(urepo.findByEmail(email)==null) {
			//if user doesn't exist, return false
			return false;
		} else {
			//otherwise return true
			return true;
		}
	}
	
	public boolean checkUser(String email, String password) {
		//Checking email and getting user details from DB
		User usr = urepo.findByEmail(email);
		////Getting DB password of user using email
		String db_password = usr.getPassword();
		//Checking whether user entered password and DB password are same
		if(db_password.equals(password)) {
			//if same, returning true
			return true;
		}
		else{
			//if not same, returning false
			return false;
		}
	}

	@Override
	public List<User> viewUser() {
		List<User> userList = urepo.findAll();
		return userList;
	}
	
	@Override
	public User getUser(String email) {
		return urepo.findByEmail(email);
	}
	
	
	@Override
	public void updateUser(User user) {
		urepo.save(user);
	}


	@Override
	public void updateUser(User user, String email) {
		// TODO Auto-generated method stub
		User u =urepo.findByEmail(email);
		u.setName(user.getName());
		u.setAddress(user.getAddress());
		u.setPassword(user.getPassword());
		u.setGender(user.getGender());
		u.setPhone(user.getPhone());
		urepo.save(u);
		
	}
	
	
	


	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		if(urepo.existsById(id)) {
			//if user doesn't exist, return false
			urepo.deleteById(id);
			return true;
		} else {
			//otherwise return true
			return false;
		}
		
	}
}