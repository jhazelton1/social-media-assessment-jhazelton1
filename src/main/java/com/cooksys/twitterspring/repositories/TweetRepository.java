package com.cooksys.twitterspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.twitterspring.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{

}
