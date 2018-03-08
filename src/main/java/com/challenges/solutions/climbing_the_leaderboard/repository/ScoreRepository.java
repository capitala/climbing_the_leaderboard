package com.challenges.solutions.climbing_the_leaderboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenges.solutions.climbing_the_leaderboard.controller.Entity.ScoreTracker;
@Repository
public interface ScoreRepository extends CrudRepository<ScoreTracker, Long>{

}
