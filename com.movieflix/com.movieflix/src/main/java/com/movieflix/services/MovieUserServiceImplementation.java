package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.MovieUser;
import com.movieflix.repositories.MovieUserRepository;


@Service
public class MovieUserServiceImplementation implements MovieUserService{
	
	@Autowired
	MovieUserRepository mUserRepo;
	
	@Override
	public String addMovieUser(MovieUser muser) {
		mUserRepo.save(muser);
		return "Movie User Successfully Saved In to the database";
	}
	
	@Override
	public boolean emailExistOrNot(String emailId) {
		if(mUserRepo.findByEmailId(emailId)==null) {
			return false;
		}
		
		return true;
	}
	
	public boolean verifyUserDetails(String emailId,String password){
		MovieUser us = mUserRepo.findByEmailId(emailId);
		if(us.getPassword().equals(password)) {
			return true;
		}
		return false;
		
	}
	
	public List<MovieUser> fetchAll(){
		List<MovieUser> musers= mUserRepo.findAll();
		return musers;
	}
	
}
