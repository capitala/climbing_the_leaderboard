package com.challenges.solutions.climbing_the_leaderboard.integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.challenges.solutions.climbing_the_leaderboard.App;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@ActiveProfiles("testing")
@AutoConfigureMockMvc
public class IntegrationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void getRankingsIntegrationTest() throws Exception
	{
		mockMvc.perform(get("/getRankings?highestScores=100,100,50,40,40,20,10&scores=5,25,50,120"))
				.andExpect(status().isOk()).andExpect(content().string("6 4 2 1"));
	}
}
