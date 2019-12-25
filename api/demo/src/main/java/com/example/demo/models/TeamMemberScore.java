package com.example.demo.models;

import java.util.List;

public class TeamMemberScore {
	int TeamId;
	String TeamName;
	List<MemberScore> Members;
	public int getTeamId() {
		return TeamId;
	}
	public void setTeamId(int teamId) {
		TeamId = teamId;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public List<MemberScore> getMembers() {
		return Members;
	}
	public void setMembers(List<MemberScore> members) {
		Members = members;
	}
	

	
}
