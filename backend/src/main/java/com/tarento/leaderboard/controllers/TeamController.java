package com.tarento.leaderboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarento.leaderboard.models.Member;
import com.tarento.leaderboard.models.MemberScore;
import com.tarento.leaderboard.models.Team;
import com.tarento.leaderboard.service.TeamService;

@RestController
@RequestMapping(value = "/team")
public class TeamController {
	
	@Autowired
	TeamService teamService; 
	
	@RequestMapping(value = "/getTeams", method = RequestMethod.GET)
	public Object getTeams() {
		return teamService.getTeams(); 
	}
	
	@RequestMapping(value = "/addTeam", method = RequestMethod.POST)
	public Object addTeam(@RequestBody Team team) {
		return teamService.addTeam(team);
	}
	
	@RequestMapping(value = "/addMemberToTeam", method = RequestMethod.POST)
	public Object addMemberToTeam(@RequestBody Member member) {
		return teamService.addMemberToTeam(member);
	}
	
	@RequestMapping(value = "/addScores", method = RequestMethod.POST)
	public Object addScores(@RequestBody MemberScore memberScore) {
		return teamService.addScores(memberScore);
	}
	
	@RequestMapping(value = "/getTeamScores", method = RequestMethod.GET)
	public Object getTeamScores(){
		return teamService.getTeamScores();
	}

}
