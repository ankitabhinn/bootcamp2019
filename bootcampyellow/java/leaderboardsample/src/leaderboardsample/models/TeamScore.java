package leaderboardsample.models;

import java.util.List;

public class TeamScore extends Team{
	public List<MemberScore> members;

	public List<MemberScore> getMembers() {
		return members;
	}

	public void setMembers(List<MemberScore> members) {
		this.members = members;
	}
	

}
