package com.challenges.solutions.climbing_the_leaderboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenges.solutions.climbing_the_leaderboard.controller.Entity.ScoreTracker;
import com.challenges.solutions.climbing_the_leaderboard.service.SolutionService;

@Controller
public class SolutionController {
@Autowired
private SolutionService serve;
@RequestMapping("/getRankings")
@ResponseBody
public String getRankings(@RequestParam("highestScores") int[] highestScores,@RequestParam("scores") int[] scores){

	String result=serve.getRankings(highestScores,scores);	
	return result;
}
@RequestMapping("/getAttempts")
@ResponseBody
public List<ScoreTracker> getAttempts(){

	List<ScoreTracker> result=serve.getAttempts();	
	return result;
}
	
}
