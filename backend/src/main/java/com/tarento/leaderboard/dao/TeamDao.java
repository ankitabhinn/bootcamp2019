package com.tarento.leaderboard.dao;

import java.util.List;

import com.tarento.leaderboard.models.Member;
import com.tarento.leaderboard.models.MemberScore;
import com.tarento.leaderboard.models.Team;
import com.tarento.leaderboard.models.TeamMembers;

public interface TeamDao {
	
	public List<TeamMembers> getTeamDetails();
	public List<Team> getTeams();
	public Team addTeam(Team team); 
	public Member addMemberToTeam(Member member); 
	public MemberScore addScores(MemberScore memberScore); 
	public List<TeamMembers> getTeamScores(); 

}
