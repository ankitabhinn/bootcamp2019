package com.example.demo.models;

import java.util.List;

public class TeamMember {

	private int teamID;
	private String teamName;
	private List<MemberScore> members;
	
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
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
