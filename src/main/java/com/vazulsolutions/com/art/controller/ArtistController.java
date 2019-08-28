package com.vazulsolutions.com.art.controller;

import com.vazulsolutions.com.art.model.Artist;
import com.vazulsolutions.com.art.repo.ArtistRepo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {
	
	@Autowired
	private ArtistRepo artistRepo;
	
	
	@GetMapping("/Artist")
	public Optional<Artist> fetchAll(@RequestParam(value = "id", required = true) long id) {
		return artistRepo.findById(id);
	}
	
	@PostMapping("/Artist")
	public void insertArtist(@Valid @RequestBody Artist entity) {
		artistRepo.save(entity);
	}
	
}
