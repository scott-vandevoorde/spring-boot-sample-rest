package com.vazulsolutions.com.art.repo;

import com.vazulsolutions.com.art.model.Artist;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long> {

	List<Artist> findByBeginDate(Integer beginDate);

	Page<Artist> findByBeginDate(Integer beginDate, Pageable page);
}
