package com.tarento.leaderboard.models;

import java.util.List;

public class TeamMembers {

	private int teamId;
	private String teamName;
	private int teamScore; 
	private List<MemberScore> members;
	
	public int getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<MemberScore> getMembers() {
		return members;
	}

	public void setMembers(List<MemberScore> members) {
		this.members = members;
	}

}
