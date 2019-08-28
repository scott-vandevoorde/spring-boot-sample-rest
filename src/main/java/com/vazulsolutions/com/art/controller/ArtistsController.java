package com.vazulsolutions.com.art.controller;

import com.vazulsolutions.com.art.model.Artist;
import com.vazulsolutions.com.art.repo.ArtistRepo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistsController {

	private static final String PAGE_SIZE = "pageSize";
	
	private static final String PAGE_OFFSET = "pageOffset";
	
	@Autowired
	private ArtistRepo artistRepo;
	
	@GetMapping("/Artists")
	public Page<Artist> fetchByPage(@RequestParam(value = PAGE_SIZE, required = true) int pageSize, @RequestParam(value = PAGE_OFFSET, required = true) int pageOffset) {
		PageRequest page = PageRequest.of(pageOffset, pageSize);
		return artistRepo.findAll(page);
	}
	
	@PostMapping("/Artists")
	public void insertAll(@RequestBody ArrayList<Artist> entities) {
		artistRepo.saveAll(entities);
	}
	
	@GetMapping("/SearchArtists")
	public Page<Artist> getArtistsByPageFilterByDate(@RequestParam(value = PAGE_SIZE, required = true) int pageSize, @RequestParam(value = PAGE_OFFSET, required = true) int pageOffset, @RequestParam(value = "year", required = true) int year) {
		Pageable pageable = PageRequest.of(pageOffset, pageSize);
		return artistRepo.findByBeginDate(year, pageable);
	}
}
