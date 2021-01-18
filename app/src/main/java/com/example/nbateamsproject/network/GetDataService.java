package com.example.nbateamsproject.network;

import com.example.nbateamsproject.teamsJSON.NbaItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/bttmly/nba/master/data/teams.json")
    Call<List<NbaItems>> getTeams();
}
