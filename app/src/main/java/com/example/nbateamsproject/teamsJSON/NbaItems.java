package com.example.nbateamsproject.teamsJSON;

import com.google.gson.annotations.SerializedName;

public class NbaItems {

	@SerializedName("teamName")
	private String teamName;

	@SerializedName("simpleName")
	private String simpleName;

	@SerializedName("teamId")
	private int teamId;

	@SerializedName("location")
	private String location;

	@SerializedName("abbreviation")
	private String abbreviation;

	public String getTeamName(){
		return teamName;
	}

	public String getSimpleName(){
		return simpleName;
	}

	public int getTeamId(){
		return teamId;
	}

	public String getLocation(){
		return location;
	}

	public String getAbbreviation(){
		return abbreviation;
	}
}