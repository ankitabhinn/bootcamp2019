package com.example.demo.models;

import java.util.List;

public class TeamMember{
	int teamId;
	String teamName;
	List<MemberScore> members;
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
