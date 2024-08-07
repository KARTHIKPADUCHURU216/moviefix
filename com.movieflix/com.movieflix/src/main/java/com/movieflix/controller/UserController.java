package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.MovieUser;
import com.movieflix.services.MovieUserService;

@Controller
public class UserController {

	@Autowired
	MovieUserService mUserServ;
	
	@PostMapping("register")
	public String addMovieUser(@ModelAttribute MovieUser user) {
		if(mUserServ.emailExistOrNot(user.getEmailId())==false) {
			mUserServ.addMovieUser(user);
			return "regSuccess";
		}
		
		return "regFailed";
	}
	
	@PostMapping("login")
	public String verifyUserDetails(@RequestParam String emailId,String password) {
		if(emailId.equalsIgnoreCase("admin@gmail.com")) {
			if(mUserServ.emailExistOrNot(emailId)) {
				if(mUserServ.verifyUserDetails(emailId, password)) {
					return "adminHome";
				}
			}
		}else {
			if(mUserServ.verifyUserDetails(emailId, password)) {
				return "userHome";
			}
		}
		return "loginFailed";
	}
	
	@GetMapping("map_viewallusers")
	public String fetchAllUsersData(Model model) {
		List<MovieUser> allUsers= mUserServ.fetchAll();
		model.addAttribute("users", allUsers);
		return "allUserDetails";
		
	}
	
}
