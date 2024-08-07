package com.movieflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController {
	@GetMapping("map-register")
	public String mapRegister() 
	{
		return "register";
	}
	@GetMapping("map-login")
	public String mapLogin() {
		return "login";
	}
	@GetMapping("map-addmovie")
	public String mapAddMovie()
	{
		return "addmovie";
	}
	@GetMapping("deleteuser")
	public String  deleteuser()
	{
		return "deleteuser";
	}
	@GetMapping("map-updateuser")
	public String updateUser()
	{
		return "updateuser";
	}
}