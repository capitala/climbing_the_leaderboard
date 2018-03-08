package com.challenges.solutions.climbing_the_leaderboard.controller.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScoreTracker {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private int attempt;
    private int score;
    private int rank;
    public ScoreTracker(String name,int attempt,int score,int rank){
    	this.name=name;
    	this.attempt=attempt;
    	this.score=score;
    	this.rank=rank;
    }
    public ScoreTracker(){
    	
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', attempt='%s',score='%d',rank='%d']",
                id, name,attempt,score,rank);
    }
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}
