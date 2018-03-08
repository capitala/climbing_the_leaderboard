package com.challenges.solutions.climbing_the_leaderboard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenges.solutions.climbing_the_leaderboard.controller.Entity.ScoreTracker;
import com.challenges.solutions.climbing_the_leaderboard.performanceMonitor.TrackTime;
import com.challenges.solutions.climbing_the_leaderboard.repository.ScoreRepository;

@Service
public class SolutionService {

	@Autowired
	private ScoreRepository scoreRepository;
	private static Set<Integer> rankingSet = new LinkedHashSet<Integer>();
	private Iterator<Integer> itr;

	static int index ;
	int e;

	public void setrankingSet(int[] highestScores) {
		Arrays.sort(highestScores);
		for (int i = 0; i < highestScores.length; i++)
			rankingSet.add(highestScores[i]);
		itr = rankingSet.iterator();
	}

	public int getRank(int score) {
		if (score < e)
			return rankingSet.size() + 1 - (index);
		else if (score == e)
			return rankingSet.size() - (index);
		while (itr.hasNext()) {
			e = (Integer) itr.next();
			index++;
			if (score < e) {
				return rankingSet.size() + 1 - (index);

			} else if (score == e)
				return rankingSet.size() - (index);
		}
		/*
		 * for (Integer e : rankingSet) { if (score > e) { index++;
		 * 
		 * } else if (score < e) { return rankingSet.size() + 1 - (index);
		 * 
		 * } else return rankingSet.size() - (index);
		 * 
		 * }
		 */
		return 1;
	}

	@TrackTime
	public String getRankings(int[] highestScores, int[] scores) {
		index = -1;
		e=-1;
		StringBuilder sb = new StringBuilder();
		setrankingSet(highestScores);
		for (int i = 0; i < scores.length; i++) {
			int rank = getRank(scores[i]);
			if (i != scores.length - 1)
				sb.append(rank + " ");
			else
				sb.append(rank);
			scoreRepository.save(new ScoreTracker("Alice", i + 1, scores[i], rank));
		}
		return sb.toString();
	}

	public List<ScoreTracker> getAttempts() {
		List<ScoreTracker> result = (ArrayList<ScoreTracker>) scoreRepository.findAll();
		// TODO Auto-generated method stub
		return result;
	}

}
