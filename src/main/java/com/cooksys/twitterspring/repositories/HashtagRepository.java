package com.cooksys.twitterspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.twitterspring.entities.Hashtag;

public interface HashtagRepository extends JpaRepository<Hashtag, Integer> {
	
	Hashtag findByLabel(String label);

}
