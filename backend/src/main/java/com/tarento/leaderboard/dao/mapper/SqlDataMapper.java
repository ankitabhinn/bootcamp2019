package com.tarento.leaderboard.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.tarento.leaderboard.models.MemberScore;
import com.tarento.leaderboard.models.TeamMembers;

public class SqlDataMapper {
	
	public class TeamMemberMapper implements RowMapper<TeamMembers> {
		public Map<Integer, TeamMembers> idMemberMap = new HashMap<>(); 
		public TeamMembers mapRow(ResultSet rs, int rowNum) throws SQLException {
			if(!idMemberMap.containsKey(rs.getInt("TeamId"))) { 
				TeamMembers member = new TeamMembers(); 
				member.setTeamId(rs.getInt("TeamId")); 
				member.setTeamName(rs.getString("TeamName"));
				MemberScore score = new MemberScore(); 
				score.setId(rs.getInt("MemberId"));
				score.setMemberName(rs.getString("MemberName"));
				score.setTeamId(rs.getInt("MemberTeamId"));
				score.setScore(rs.getInt("MemberScore"));
				List<MemberScore> scoreList = new ArrayList<>(); 
				scoreList.add(score);
				member.setTeamScore(rs.getInt("MemberScore"));
				member.setMembers(scoreList);
				idMemberMap.put(rs.getInt("TeamId"), member);
			} else { 
				TeamMembers member = idMemberMap.get(rs.getInt("TeamId"));
				MemberScore score = new MemberScore(); 
				score.setId(rs.getInt("MemberId"));
				score.setMemberName(rs.getString("MemberName"));
				score.setTeamId(rs.getInt("MemberTeamId"));
				score.setScore(rs.getInt("MemberScore"));
				int teamScore = member.getTeamScore();
				teamScore = teamScore + rs.getInt("MemberScore"); 
				member.setTeamScore(teamScore);
				member.getMembers().add(score);
			}
			return null; 
		}
	}

}

