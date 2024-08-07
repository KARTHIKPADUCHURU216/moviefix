package com.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.movieflix.entities.Movie;
import com.movieflix.services.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService mServ;
	
	@PostMapping("add_Movie")
	public String addMovie(@ModelAttribute Movie movie) {
		mServ.addMovie(movie);
		return "movieAddSuccess";
	}
	
	
}
