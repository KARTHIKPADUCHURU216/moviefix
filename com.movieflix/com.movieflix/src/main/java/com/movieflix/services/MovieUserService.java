package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.MovieUser;

public interface MovieUserService {
	
	
	public String addMovieUser(MovieUser muser);
	
	public boolean emailExistOrNot(String emailId);

	public boolean verifyUserDetails(String emailId, String password);
	
	public List<MovieUser> fetchAll();
}
