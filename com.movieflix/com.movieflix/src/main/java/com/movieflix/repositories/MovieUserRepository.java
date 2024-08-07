package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.MovieUser;

public interface MovieUserRepository extends JpaRepository<MovieUser, Integer> {

	
	public MovieUser findByEmailId(String emailId);
	
}
