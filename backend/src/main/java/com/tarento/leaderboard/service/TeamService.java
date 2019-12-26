package com.tarento.leaderboard.service;

import java.util.List;

import com.tarento.leaderboard.models.Member;
import com.tarento.leaderboard.models.MemberScore;
import com.tarento.leaderboard.models.Team;

public interface TeamService {
	public List<Team> getTeams();
	public Object addTeam(Team team); 
	public Object addMemberToTeam(Member member);
	public Object addScores(MemberScore memberScore);
	public Object getTeamScores(); 
}
