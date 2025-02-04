package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);



}
