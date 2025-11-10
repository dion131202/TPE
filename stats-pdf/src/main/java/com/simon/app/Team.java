package com.simon.app;

import java.util.ArrayList;
import java.util.HashMap;

import com.simon.helpers.Helpers;
import com.simon.stats.TeamStats;

public class Team {
    String teamName;
    ArrayList<Game> games;
    ArrayList<TeamStats> teamStatsForList = new ArrayList<TeamStats>();
    ArrayList<TeamStats> teamStatsAgainstList = new ArrayList<TeamStats>();
    HashMap<String, Double> meanPerStatsFor;
    HashMap<String, Double> meanPerStatsAgainst;
    HashMap<String, Double> stdDevPerStatsFor;
    HashMap<String, Double> stdDevPerStatsAgainst;

    public Team(String teamName){
        this.teamName = teamName;
        this.games = new ArrayList<Game>();
    }

    public void addGame(Game game){
        this.games.add(game);   
    }

    public void addTeamStatsToList(TeamStats teamStats){

        if(teamStats.getIsTeamFor()){
            teamStatsForList.add(teamStats);
        }
        else{
            teamStatsAgainstList.add(teamStats);
        }

        computeMeanAndStdDev();
    }

    public void computeMeanAndStdDev(){

        this.meanPerStatsFor = Helpers.meanPerStats(this.teamStatsForList);
        this.meanPerStatsAgainst = Helpers.meanPerStats(this.teamStatsAgainstList);

        this.stdDevPerStatsFor = Helpers.stdDevPerStats(this.teamStatsForList, this.meanPerStatsFor);
        this.stdDevPerStatsAgainst = Helpers.stdDevPerStats(this.teamStatsAgainstList, this.meanPerStatsAgainst);
    }

    public HashMap<String, Double> setzScoresPerGame(HashMap<String, Double> teamStats, boolean isTeamFor){

        if(isTeamFor){
            return Helpers.zScoresPerGame(teamStats, this.meanPerStatsFor, this.stdDevPerStatsFor);
        }
        else{
            return Helpers.zScoresPerGame(teamStats, this.meanPerStatsAgainst, this.stdDevPerStatsAgainst);
        }
    }

    public String getName() {
        
        return this.teamName;
    }
}