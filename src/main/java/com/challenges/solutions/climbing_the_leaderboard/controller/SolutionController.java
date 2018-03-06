package com.challenges.solutions.climbing_the_leaderboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.challenges.solutions.climbing_the_leaderboard.service.SolutionService;

@Controller
public class SolutionController {
@Autowired
private SolutionService serve;
@RequestMapping("/getRankings")
public String getRankings(@RequestParam("rankings") String[] rankings,@RequestParam("scores") String[] scores){

	return serve.getRankings(rankings,scores);	
}
	
}
