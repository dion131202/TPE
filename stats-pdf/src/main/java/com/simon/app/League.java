package com.simon.app;
import java.util.ArrayList;

public class League{
    String leagueName;
    int season;
    ArrayList<Game> games; 
    ArrayList<Team> teams;

    public League(String leagueName, int season){
        this.leagueName = leagueName;
        this.season = season;
        this.games = new ArrayList<Game>();
        this.teams = new ArrayList<Team>();
    }

    public void addTeam(Team team){
        this.teams.add(team);   
    }

    public void addGame(Game game){
        this.games.add(game);
    }
}