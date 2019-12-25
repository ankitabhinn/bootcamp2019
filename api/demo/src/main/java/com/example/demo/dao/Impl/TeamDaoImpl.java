package com.example.demo.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.TeamDao;
import com.example.demo.models.Team;

@Repository(value = "teamDao")
public class TeamDaoImpl implements TeamDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Object getTeams() {
		List<Team> teamList = new ArrayList<>();
		try {
			teamList = jdbcTemplate.query("select Id, TeamName from Team",new RowMapper<Team>() {
				public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
					Team team = new Team(); 
					team.setTeamid(rs.getInt("Id"));
					team.setTeamname(rs.getString("TeamName"));
					return team;
				}
			});
			
		} catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
		
		// TODO Auto-generated method stub
		
		return teamList;
	}
	
	@Override
    public Team addTeam(Team team) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    String[] returnValColumn = new String[] { "id" };
                    PreparedStatement statement = con.prepareStatement("insert into Team values (?,?,now())", returnValColumn);
                    statement.setInt(1, team.getTeamid());
                    statement.setString(2, team.getTeamname());
                    return statement;
                }
            }, keyHolder);
            Long id = keyHolder.getKey().longValue();
        } catch (Exception e) {
            System.out.println("Error while adding a new team : " + e.getMessage());
        }
        return team; 
    }


}
