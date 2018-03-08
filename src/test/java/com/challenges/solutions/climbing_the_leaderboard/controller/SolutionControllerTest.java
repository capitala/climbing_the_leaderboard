package com.challenges.solutions.climbing_the_leaderboard.controller;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.challenges.solutions.climbing_the_leaderboard.controller.Entity.ScoreTracker;
import com.challenges.solutions.climbing_the_leaderboard.repository.ScoreRepository;
import com.challenges.solutions.climbing_the_leaderboard.service.SolutionService;

@RunWith(SpringRunner.class)
@WebMvcTest(SolutionController.class)
public class SolutionControllerTest {
	@MockBean
	private SolutionService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getRankingsTest() throws Exception {
		Mockito.when(service.getRankings(new int[] { 100, 100, 50, 40, 40, 20, 10 }, new int[] { 5, 25, 50, 120 }))
				.thenReturn("6 4 2 1");
		mockMvc.perform(get("/getRankings?highestScores=100,100,50,40,40,20,10&scores=5,25,50,120"))
				.andExpect(status().isOk()).andExpect(content().string("6 4 2 1"));
	}
}
