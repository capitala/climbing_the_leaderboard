package com.challenges.solutions.climbing_the_leaderboard.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenges.solutions.climbing_the_leaderboard.controller.Entity.ScoreTracker;
import com.challenges.solutions.climbing_the_leaderboard.repository.ScoreRepository;
@RunWith(SpringRunner.class)
@WebMvcTest(SolutionService.class)
public class SolutionServiceTest {
	@MockBean
	private ScoreRepository scoreRepository;
	@Autowired
	private SolutionService service;

	@Before
	public void setUp() {
		Mockito.when(scoreRepository.save(any(ScoreTracker.class))).thenReturn(new ScoreTracker());
	}

	@Test
	public void getRankingsCase1() {

		String result = service.getRankings(new int[] { 100, 100, 50, 40, 40, 20, 10 }, new int[] { 5, 25, 50, 120 });
		assertEquals("6 4 2 1", result);
	}

	@Test
	public void getRankingsCase2() {
		String result = service.getRankings(new int[] { 200, 100, 50, 40, 40, 20, 10 }, new int[] { 15, 25, 50, 120 });
		assertEquals("6 5 3 2", result);
	}
}
