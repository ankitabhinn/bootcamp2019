package com.tarento.leaderboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarento.leaderboard.dao.TeamDao;
import com.tarento.leaderboard.models.Member;
import com.tarento.leaderboard.models.MemberScore;
import com.tarento.leaderboard.models.Team;
import com.tarento.leaderboard.models.TeamMembers;
import com.tarento.leaderboard.service.TeamService;

@Service(value="teamService")
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamDao teamDao; 

	@Override
	public List<Team> getTeams() {
		return teamDao.getTeams();
	}

	@Override
	public Object addTeam(Team team) {
		return teamDao.addTeam(team);
	}

	@Override
	public Object addMemberToTeam(Member member) {
		return teamDao.addMemberToTeam(member); 
	}

	@Override
	public Object addScores(MemberScore memberScore) {
		return teamDao.addScores(memberScore);
	}

	@Override
	public Object getTeamScores() {
		return teamDao.getTeamScores(); 
	}

}
