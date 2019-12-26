package com.tarento.leaderboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tarento.leaderboard.dao.TeamDao;
import com.tarento.leaderboard.dao.mapper.SqlDataMapper;
import com.tarento.leaderboard.dao.mapper.SqlDataMapper.TeamMemberMapper;
import com.tarento.leaderboard.models.Member;
import com.tarento.leaderboard.models.MemberScore;
import com.tarento.leaderboard.models.Team;
import com.tarento.leaderboard.models.TeamMembers;

@Repository("teamDao")
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<TeamMembers> getTeamDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getTeams() {
		List<Team> teams = new ArrayList<>(); 
		try { 
			teams = jdbcTemplate.query("select Id, TeamName from Team", new RowMapper<Team>() {
				public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
					Team team = new Team(); 
					team.setId(rs.getInt("Id"));
					team.setTeamName(rs.getString("TeamName"));
					return team;
				}
			});
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		}
		return teams;
	}

	@Override
	public Team addTeam(Team team) {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String[] returnValColumn = new String[] { "id" };
					PreparedStatement statement = con.prepareStatement("insert into Team (TeamName, CreationDate) values  (?,now())", returnValColumn);
					statement.setString(1, team.getTeamName());
					return statement;
				}
			}, keyHolder);
			int id = keyHolder.getKey().intValue();
			team.setId(id);
		} catch (Exception e) {
			System.out.println("Error while adding a new team : " + e.getMessage());
		}
		return team; 
	}

	@Override
	public Member addMemberToTeam(Member member) {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String[] returnValColumn = new String[] { "id" };
					PreparedStatement statement = con.prepareStatement("insert into Member (MemberName, TeamId, Email, CreationDate) values  (?, ?, ?,now())", returnValColumn);
					statement.setString(1, member.getMemberName());
					statement.setInt(2, member.getTeamId()); 
					statement.setString(3, member.getEmailId());
					return statement;
				}
			}, keyHolder);
			int id = keyHolder.getKey().intValue();
			member.setId(id);
		} catch (Exception e) {
			System.out.println("Error while adding a new team : " + e.getMessage());
		}
		return member; 
	}

	@Override
	public MemberScore addScores(MemberScore memberScore) {
		List<TeamMembers> teamMembers = getTeamScores();
		Boolean updatedOrNot = Boolean.FALSE; 
		if(teamMembers != null && teamMembers.size() > 0) { 
			for(TeamMembers eachTeam : teamMembers) { 
				if(eachTeam.getMembers() != null && eachTeam.getMembers().size() > 0) { 
					for(MemberScore score : eachTeam.getMembers()) { 
						if(score.getId() == memberScore.getId() && score.getTeamId() == memberScore.getTeamId()) { 
							int newScore = score.getScore() + memberScore.getScore() ; 
							try {
								if(score.getScore() == 0) { 
									jdbcTemplate.update("insert into IndividualScore (MemberId, TeamId, Score) values  (?, ?, ?) ",
											new Object[] { memberScore.getId(), memberScore.getTeamId(), newScore });
								} else {
									jdbcTemplate.update("update IndividualScore set score = ? where MemberId = ? and TeamId = ? ",
											new Object[] { newScore, memberScore.getId(), memberScore.getTeamId() });
								}
								
								updatedOrNot = Boolean.TRUE;
							} catch (Exception e) {
								System.out.println("Error while updating a Score : " + e.getMessage());
							}
						}
					}
				}
			}
		} 
		if(!updatedOrNot) { 
			try {
				KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String[] returnValColumn = new String[] { "id" };
						PreparedStatement statement = con.prepareStatement("insert into IndividualScore (MemberId, TeamId, Score) values  (?, ?, ?)", returnValColumn);
						statement.setInt(1, memberScore.getId());
						statement.setInt(2, memberScore.getTeamId()); 
						statement.setInt(3, memberScore.getScore());
						return statement;
					}
				}, keyHolder);
			} catch (Exception e) {
				System.out.println("Error while adding a new score : " + e.getMessage());
			}
		}
		return memberScore; 
	}

	@Override
	public List<TeamMembers> getTeamScores() {
		List<TeamMembers> teamMembers = new ArrayList<>(); 
		TeamMemberMapper mapper = new SqlDataMapper().new TeamMemberMapper(); 
		String query = "select team.Id as TeamId, team.TeamName as TeamName, " + 
				" member.Id as MemberId, member.MemberName as MemberName, member.TeamId as MemberTeamId, " + 
				" scores.Score as MemberScore " + 
				" FROM Team team LEFT JOIN Member member ON team.Id = member.TeamId " + 
				" LEFT JOIN IndividualScore scores ON member.Id = scores.MemberId AND team.Id  = scores.TeamId " ; 
		try { 
			teamMembers = jdbcTemplate.query(query, mapper) ;
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		}
		return getListOfScores(mapper.idMemberMap);
	}
	
	private List<TeamMembers> getListOfScores(Map<Integer, TeamMembers> membersMap) {
		List<TeamMembers> membersList = new ArrayList<>(); 
		Iterator<Entry<Integer, TeamMembers>> itr = membersMap.entrySet().iterator();
		while(itr.hasNext()) { 
			membersList.add(itr.next().getValue());
		}
		return membersList; 
	}

}
