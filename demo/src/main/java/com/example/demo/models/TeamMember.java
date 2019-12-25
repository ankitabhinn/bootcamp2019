package com.example.demo.models;

import java.util.List;

public class TeamMember{
	public int tid;
	public String tname;
	public List<MemberScore> members;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<MemberScore> getMembers() {
		return members;
	}
	public void setMembers(List<MemberScore> members) {
		this.members = members;
	}

}
