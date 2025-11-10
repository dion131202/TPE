package com.simon.app;
import java.io.IOException;
import java.util.HashMap;

import com.simon.helpers.Helpers;
import com.simon.stats.TeamStats;
import com.simon.stats.defense.Defense;
import com.simon.stats.defense.exits.Exits;
import com.simon.stats.offense.Offense;
import com.simon.stats.offense.entries.Entries;
import com.simon.stats.offense.entries.controlledEntries.ControlledEntries;
import com.simon.stats.offense.entries.uncontrolledEntries.UncontrolledEntries;
import com.simon.stats.offense.offenseAttack.OffenseAttack;
import com.simon.stats.offense.offenseControl.OffenseControl;
import com.simon.stats.transition.Transition;

public class Game {
    String gameId;
    String date;
    String filePathTeam1;
    String filePathTeam2;
    Team team1;
    Team team2;
    TeamStats team1StatsFor;
    TeamStats team1StatsAgainst;
    TeamStats team2StatsFor;
    TeamStats team2StatsAgainst;

    HashMap<String, Double> allzScoresPerGameForTeam1;
    HashMap<String, Double> allzScoresPerGameAgainstTeam1;
    HashMap<String, Double> allzScoresPerGameForTeam2;
    HashMap<String, Double> allzScoresPerGameAgainstTeam2;

    double evaluationForTeam1;
    double offenseEvaluationForTeam1;
    double offenseControlEvaluationForTeam1;
    double offenseControlGoodEvaluationForTeam1;
    double offenseControlBadEvaluationForTeam1;
    double entriesEvaluationForTeam1;
    double controlledEntriesEvaluationForTeam1;
    double controlledEntriesGoodEvaluationForTeam1;
    double controlledEntriesBadEvaluationForTeam1;
    double uncontrolledEntriesEvaluationForTeam1;
    double uncontrolledEntriesGoodEvaluationForTeam1;
    double uncontrolledEntriesBadEvaluationForTeam1;
    double offenseWithoutPuckEvaluationForTeam1;
    double offenseAttackEvaluationForTeam1;
    double offenseAttackGoodEvaluationForTeam1;
    double offenseAttackBadEvaluationForTeam1;
    double defenseEvaluationForTeam1;
    double defensiveZoneDefenseEvaluationForTeam1;
    double neutralzoneDefenseEvaluationForTeam1;
    double exitsEvaluationForTeam1;
    double exitsGoodEvaluationForTeam1;
    double exitsBadEvaluationForTeam1;
    double transitionEvaluationForTeam1;
    double transitionGoodEvaluationForTeam1;
    double transitionBadEvaluationForTeam1;
    double energyManagementEvaluationForTeam1;
    double physicalityEvaluationForTeam1;

    double evaluationAgainstTeam1;
    double offenseEvaluationAgainstTeam1;
    double offenseControlEvaluationAgainstTeam1;
    double offenseControlGoodEvaluationAgainstTeam1;
    double offenseControlBadEvaluationAgainstTeam1;
    double entriesEvaluationAgainstTeam1;
    double controlledEntriesEvaluationAgainstTeam1;
    double controlledEntriesGoodEvaluationAgainstTeam1;
    double controlledEntriesBadEvaluationAgainstTeam1;
    double uncontrolledEntriesEvaluationAgainstTeam1;
    double uncontrolledEntriesGoodEvaluationAgainstTeam1;
    double uncontrolledEntriesBadEvaluationAgainstTeam1;
    double offenseWithoutPuckEvaluationAgainstTeam1;
    double offenseAttackEvaluationAgainstTeam1;
    double offenseAttackGoodEvaluationAgainstTeam1;
    double offenseAttackBadEvaluationAgainstTeam1;
    double defenseEvaluationAgainstTeam1;
    double defensiveZoneDefenseEvaluationAgainstTeam1;
    double neutralzoneDefenseEvaluationAgainstTeam1;
    double exitsEvaluationAgainstTeam1;
    double exitsGoodEvaluationAgainstTeam1;
    double exitsBadEvaluationAgainstTeam1;
    double transitionEvaluationAgainstTeam1;
    double transitionGoodEvaluationAgainstTeam1;
    double transitionBadEvaluationAgainstTeam1;
    double energyManagementEvaluationAgainstTeam1;
    double physicalityEvaluationAgainstTeam1;

    double evaluationTeam1;
    double offenseEvaluationTeam1;
    double offenseControlEvaluationTeam1;
    double offenseControlGoodEvaluationTeam1;
    double offenseControlBadEvaluationTeam1;
    double entriesEvaluationTeam1;
    double controlledEntriesEvaluationTeam1;
    double controlledEntriesGoodEvaluationTeam1;
    double controlledEntriesBadEvaluationTeam1;
    double uncontrolledEntriesEvaluationTeam1;
    double uncontrolledEntriesGoodEvaluationTeam1;
    double uncontrolledEntriesBadEvaluationTeam1;
    double offenseWithoutPuckEvaluationTeam1;
    double offenseAttackEvaluationTeam1;
    double offenseAttackGoodEvaluationTeam1;
    double offenseAttackBadEvaluationTeam1;
    double defenseEvaluationTeam1;
    double defensiveZoneDefenseEvaluationTeam1;
    double neutralzoneDefenseEvaluationTeam1;
    double exitsEvaluationTeam1;
    double exitsGoodEvaluationTeam1;
    double exitsBadEvaluationTeam1;
    double transitionEvaluationTeam1;
    double transitionGoodEvaluationTeam1;
    double transitionBadEvaluationTeam1;
    double energyManagementEvaluationTeam1;
    double physicalityEvaluationTeam1;

    double evaluationForTeam2;
    double offenseEvaluationForTeam2;
    double offenseControlEvaluationForTeam2;
    double offenseControlGoodEvaluationForTeam2;
    double offenseControlBadEvaluationForTeam2;
    double entriesEvaluationForTeam2;
    double controlledEntriesEvaluationForTeam2;
    double controlledEntriesGoodEvaluationForTeam2;
    double controlledEntriesBadEvaluationForTeam2;
    double uncontrolledEntriesEvaluationForTeam2;
    double uncontrolledEntriesGoodEvaluationForTeam2;
    double uncontrolledEntriesBadEvaluationForTeam2;
    double offenseWithoutPuckEvaluationForTeam2;
    double offenseAttackEvaluationForTeam2;
    double offenseAttackGoodEvaluationForTeam2;
    double offenseAttackBadEvaluationForTeam2;
    double defenseEvaluationForTeam2;
    double defensiveZoneDefenseEvaluationForTeam2;
    double neutralzoneDefenseEvaluationForTeam2;
    double exitsEvaluationForTeam2;
    double exitsGoodEvaluationForTeam2;
    double exitsBadEvaluationForTeam2;
    double transitionEvaluationForTeam2;
    double transitionGoodEvaluationForTeam2;
    double transitionBadEvaluationForTeam2;
    double energyManagementEvaluationForTeam2;
    double physicalityEvaluationForTeam2;

    double evaluationAgainstTeam2;
    double offenseEvaluationAgainstTeam2;
    double offenseControlEvaluationAgainstTeam2;
    double offenseControlGoodEvaluationAgainstTeam2;
    double offenseControlBadEvaluationAgainstTeam2;
    double entriesEvaluationAgainstTeam2;
    double controlledEntriesEvaluationAgainstTeam2;
    double controlledEntriesGoodEvaluationAgainstTeam2;
    double controlledEntriesBadEvaluationAgainstTeam2;
    double uncontrolledEntriesEvaluationAgainstTeam2;
    double uncontrolledEntriesGoodEvaluationAgainstTeam2;
    double uncontrolledEntriesBadEvaluationAgainstTeam2;
    double offenseWithoutPuckEvaluationAgainstTeam2;
    double offenseAttackEvaluationAgainstTeam2;
    double offenseAttackGoodEvaluationAgainstTeam2;
    double offenseAttackBadEvaluationAgainstTeam2;
    double defenseEvaluationAgainstTeam2;
    double defensiveZoneDefenseEvaluationAgainstTeam2;
    double neutralzoneDefenseEvaluationAgainstTeam2;
    double exitsEvaluationAgainstTeam2;
    double exitsGoodEvaluationAgainstTeam2;
    double exitsBadEvaluationAgainstTeam2;
    double transitionEvaluationAgainstTeam2;
    double transitionGoodEvaluationAgainstTeam2;
    double transitionBadEvaluationAgainstTeam2;
    double energyManagementEvaluationAgainstTeam2;
    double physicalityEvaluationAgainstTeam2;      

    double evaluationTeam2;
    double offenseEvaluationTeam2;
    double offenseControlEvaluationTeam2;
    double offenseControlGoodEvaluationTeam2;
    double offenseControlBadEvaluationTeam2;
    double entriesEvaluationTeam2;
    double controlledEntriesEvaluationTeam2;
    double controlledEntriesGoodEvaluationTeam2;
    double controlledEntriesBadEvaluationTeam2;
    double uncontrolledEntriesEvaluationTeam2;
    double uncontrolledEntriesGoodEvaluationTeam2;
    double uncontrolledEntriesBadEvaluationTeam2;
    double offenseWithoutPuckEvaluationTeam2;
    double offenseAttackEvaluationTeam2;
    double offenseAttackGoodEvaluationTeam2;
    double offenseAttackBadEvaluationTeam2;
    double defenseEvaluationTeam2;
    double defensiveZoneDefenseEvaluationTeam2;
    double neutralzoneDefenseEvaluationTeam2;
    double exitsEvaluationTeam2;
    double exitsGoodEvaluationTeam2;
    double exitsBadEvaluationTeam2;
    double transitionEvaluationTeam2;
    double transitionGoodEvaluationTeam2;
    double transitionBadEvaluationTeam2;
    double energyManagementEvaluationTeam2;
    double physicalityEvaluationTeam2;

    public Game(String gameId, String date, String filePathTeam1, String filePathTeam2, Team team1, Team team2) throws IOException{
        this.gameId = gameId;
        this.date = date;
        this.filePathTeam1 = filePathTeam1;
        this.filePathTeam2 = filePathTeam2;
        this.team1 = team1;
        this.team2 = team2;

        init();
    }

    private void init() throws IOException{

        System.out.println("\n\n\nGame id: " + gameId + "\nDate: " + date + "\nTeams: " + team1.teamName + " vs " + team2.teamName);

        System.out.println("\n\n\n\n\n\n\n\n\n\n Building stats for Team 1 : " + team1.teamName);
        this.team1StatsFor = new TeamStats(gameId, team1, true, filePathTeam1);

        System.out.println("\n\n\n\n\n\n\n\n\n\n Building stats for Team 2 : " + team2.teamName);
        this.team2StatsFor = new TeamStats(gameId, team2, true, filePathTeam2);

        System.out.println("\n\n\n\n\n\n\n\n\n\n Building stats against Team 1 : " + team1.teamName);
        this.team1StatsAgainst = new TeamStats(gameId, team1, false, filePathTeam2);

        System.out.println("\n\n\n\n\n\n\n\n\n\n Building stats against Team 2 : " + team2.teamName);
        this.team2StatsAgainst = new TeamStats(gameId, team2, false, filePathTeam1);
    } 

    public void addStatsToTeams(){

        System.out.println("\n\n\n\n\n\n\n\n\n\n Saving all teamStats and updating means and stdDevs");
        team1.addTeamStatsToList(team1StatsFor);
        team1.addTeamStatsToList(team1StatsAgainst);

        team2.addTeamStatsToList(team2StatsFor);
        team2.addTeamStatsToList(team2StatsAgainst);
    }

    public void setTeamsZScores(){

        System.out.println("\n\n\n\n\n\n\n\n\n\n Computing all z-scores for both teams");

        allzScoresPerGameForTeam1 = team1.setzScoresPerGame(team1StatsFor.aggregatedStats, true);
        System.out.println("\nallzScoresPerGameForTeam1: \n");
        allzScoresPerGameForTeam1.forEach((k,v) -> System.out.println(k + " = " + v));

        allzScoresPerGameAgainstTeam1 = team2.setzScoresPerGame(team1StatsAgainst.aggregatedStats, false);
        System.out.println("\nallzScoresPerGameAgainstTeam1: \n");
        allzScoresPerGameAgainstTeam1.forEach((k,v) -> System.out.println(k + " = " + v));

        allzScoresPerGameForTeam2 = team2.setzScoresPerGame(team2StatsFor.aggregatedStats, true);
        System.out.println("\nallzScoresPerGameForTeam2: \n");
        allzScoresPerGameForTeam2.forEach((k,v) -> System.out.println(k + " = " + v));

        allzScoresPerGameAgainstTeam2 = team1.setzScoresPerGame(team2StatsAgainst.aggregatedStats, false);
        System.out.println("\nallzScoresPerGameAgainstTeam2: \n");
        allzScoresPerGameAgainstTeam2.forEach((k,v) -> System.out.println(k + " = " + v));

        System.out.println("\n\n\n\n\n\n\n\n\n\n Computing evaluations for both teams");

        evaluationForTeam1 = Helpers.mean(allzScoresPerGameForTeam1);
        offenseEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, TeamStats.OFFENSE_COLS));
        offenseControlEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Offense.OFFENSECONTROL_COLS));
        offenseControlGoodEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, OffenseControl.OFFENSECONTROLGOOD_COLS));
        offenseControlBadEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, OffenseControl.OFFENSECONTROLBAD_COLS));
        entriesEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Offense.ENTRIES_COLS));
        controlledEntriesEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Entries.CONTROLLEDENTRIES_COLS));
        controlledEntriesGoodEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, ControlledEntries.CONTROLLEDENTRIESGOOD_COLS));
        controlledEntriesBadEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, ControlledEntries.CONTROLLEDENTRIESBAD_COLS));
        uncontrolledEntriesEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Entries.UNCONTROLLEDENTRIES_COLS));
        uncontrolledEntriesGoodEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, UncontrolledEntries.UNCONTROLLEDENTRIESGOOD_COLS));
        uncontrolledEntriesBadEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, UncontrolledEntries.UNCONTROLLEDENTRIESBAD_COLS));
        offenseWithoutPuckEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Offense.OFFENSEWITHOUTPUCK_COLS));
        offenseAttackEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Offense.OFFENSEATTACK_COLS));
        offenseAttackGoodEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, OffenseAttack.OFFENSEATTACKGOOD_COLS));
        offenseAttackBadEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, OffenseAttack.OFFENSEATTACKBAD_COLS));
        defenseEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, TeamStats.DEFENSE_COLS));
        defensiveZoneDefenseEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Defense.DEFENSIVEZONEDEFENSE_COLS));
        neutralzoneDefenseEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Defense.NEUTRALZONEDEFENSE_COLS));
        exitsEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Defense.EXITS_COLS));
        exitsGoodEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Exits.EXITSGOOD_COLS));
        exitsBadEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Exits.EXITSBAD_COLS));
        transitionEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, TeamStats.TRANSITION_COLS));
        transitionGoodEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Transition.TRANSITIONGOOD_COLS));
        transitionBadEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, Transition.TRANSITIONBAD_COLS));
        energyManagementEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, TeamStats.ENERGYMANAGEMENT_COLS));
        physicalityEvaluationForTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam1, TeamStats.PHYSICALITY_COLS));

        evaluationAgainstTeam1 = Helpers.mean(allzScoresPerGameAgainstTeam1);
        offenseEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, TeamStats.OFFENSE_COLS));
        offenseControlEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Offense.OFFENSECONTROL_COLS));
        offenseControlGoodEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, OffenseControl.OFFENSECONTROLGOOD_COLS));
        offenseControlBadEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, OffenseControl.OFFENSECONTROLBAD_COLS));
        entriesEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Offense.ENTRIES_COLS));
        controlledEntriesEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Entries.CONTROLLEDENTRIES_COLS));
        controlledEntriesGoodEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, ControlledEntries.CONTROLLEDENTRIESGOOD_COLS));
        controlledEntriesBadEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, ControlledEntries.CONTROLLEDENTRIESBAD_COLS));
        uncontrolledEntriesEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Entries.UNCONTROLLEDENTRIES_COLS));
        uncontrolledEntriesGoodEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, UncontrolledEntries.UNCONTROLLEDENTRIESGOOD_COLS));
        uncontrolledEntriesBadEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, UncontrolledEntries.UNCONTROLLEDENTRIESBAD_COLS));
        offenseWithoutPuckEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Offense.OFFENSEWITHOUTPUCK_COLS));
        offenseAttackEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Offense.OFFENSEATTACK_COLS));  
        offenseAttackGoodEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, OffenseAttack.OFFENSEATTACKGOOD_COLS));
        offenseAttackBadEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, OffenseAttack.OFFENSEATTACKBAD_COLS));
        defenseEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, TeamStats.DEFENSE_COLS));
        defensiveZoneDefenseEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Defense.DEFENSIVEZONEDEFENSE_COLS));
        neutralzoneDefenseEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Defense.NEUTRALZONEDEFENSE_COLS));
        exitsEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Defense.EXITS_COLS));
        exitsGoodEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Exits.EXITSGOOD_COLS));
        exitsBadEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Exits.EXITSBAD_COLS));
        transitionEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, TeamStats.TRANSITION_COLS));
        transitionGoodEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Transition.TRANSITIONGOOD_COLS));
        transitionBadEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, Transition.TRANSITIONBAD_COLS));
        energyManagementEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, TeamStats.ENERGYMANAGEMENT_COLS));
        physicalityEvaluationAgainstTeam1 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam1, TeamStats.PHYSICALITY_COLS));   
        
        evaluationTeam1 = (evaluationForTeam1 + evaluationAgainstTeam1) / 2.0;
        offenseEvaluationTeam1 = (offenseEvaluationForTeam1 + offenseEvaluationAgainstTeam1) / 2.0;
        offenseControlEvaluationTeam1 = (offenseControlEvaluationForTeam1 + offenseControlEvaluationAgainstTeam1) / 2.0;
        offenseControlGoodEvaluationTeam1 = (offenseControlGoodEvaluationForTeam1 + offenseControlGoodEvaluationAgainstTeam1) / 2.0;
        offenseControlBadEvaluationTeam1 = (offenseControlBadEvaluationForTeam1 + offenseControlBadEvaluationAgainstTeam1) / 2.0;   
        entriesEvaluationTeam1 = (entriesEvaluationForTeam1 + entriesEvaluationAgainstTeam1) / 2.0;
        controlledEntriesEvaluationTeam1 = (controlledEntriesEvaluationForTeam1 + controlledEntriesEvaluationAgainstTeam1) / 2.0;
        controlledEntriesGoodEvaluationTeam1 = (controlledEntriesGoodEvaluationForTeam1 + controlledEntriesGoodEvaluationAgainstTeam1) / 2.0;
        controlledEntriesBadEvaluationTeam1 = (controlledEntriesBadEvaluationForTeam1 + controlledEntriesBadEvaluationAgainstTeam1) / 2.0;
        uncontrolledEntriesEvaluationTeam1 = (uncontrolledEntriesEvaluationForTeam1 + uncontrolledEntriesEvaluationAgainstTeam1) / 2.0;
        uncontrolledEntriesGoodEvaluationTeam1 = (uncontrolledEntriesGoodEvaluationForTeam1 + uncontrolledEntriesGoodEvaluationAgainstTeam1) / 2.0;
        uncontrolledEntriesBadEvaluationTeam1 = (uncontrolledEntriesBadEvaluationForTeam1 + uncontrolledEntriesBadEvaluationAgainstTeam1) / 2.0;
        offenseWithoutPuckEvaluationTeam1 = (offenseWithoutPuckEvaluationForTeam1 + offenseWithoutPuckEvaluationAgainstTeam1) / 2.0;
        offenseAttackEvaluationTeam1 = (offenseAttackEvaluationForTeam1 + offenseAttackEvaluationAgainstTeam1) / 2.0;
        offenseAttackGoodEvaluationTeam1 = (offenseAttackGoodEvaluationForTeam1 + offenseAttackGoodEvaluationAgainstTeam1) / 2.0;
        offenseAttackBadEvaluationTeam1 = (offenseAttackBadEvaluationForTeam1 + offenseAttackBadEvaluationAgainstTeam1) / 2.0;
        defenseEvaluationTeam1 = (defenseEvaluationForTeam1 + defenseEvaluationAgainstTeam1) / 2.0;
        defensiveZoneDefenseEvaluationTeam1 = (defensiveZoneDefenseEvaluationForTeam1 + defensiveZoneDefenseEvaluationAgainstTeam1) / 2.0;
        neutralzoneDefenseEvaluationTeam1 = (neutralzoneDefenseEvaluationForTeam1 + neutralzoneDefenseEvaluationAgainstTeam1) / 2.0;
        exitsEvaluationTeam1 = (exitsEvaluationForTeam1 + exitsEvaluationAgainstTeam1) / 2.0;
        exitsGoodEvaluationTeam1 = (exitsGoodEvaluationForTeam1 + exitsGoodEvaluationAgainstTeam1) / 2.0;
        exitsBadEvaluationTeam1 = (exitsBadEvaluationForTeam1 + exitsBadEvaluationAgainstTeam1) / 2.0;
        transitionEvaluationTeam1 = (transitionEvaluationForTeam1 + transitionEvaluationAgainstTeam1) / 2.0;
        transitionGoodEvaluationTeam1 = (transitionGoodEvaluationForTeam1 + transitionGoodEvaluationAgainstTeam1) / 2.0;
        transitionBadEvaluationTeam1 = (transitionBadEvaluationForTeam1 + transitionBadEvaluationAgainstTeam1) / 2.0;
        energyManagementEvaluationTeam1 = (energyManagementEvaluationForTeam1 + energyManagementEvaluationAgainstTeam1) / 2.0;
        physicalityEvaluationTeam1 = (physicalityEvaluationForTeam1 + physicalityEvaluationAgainstTeam1) / 2.0;

        evaluationForTeam2 = Helpers.mean(allzScoresPerGameForTeam2);
        offenseEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, TeamStats.OFFENSE_COLS));
        offenseControlEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Offense.OFFENSECONTROL_COLS));
        offenseControlGoodEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, OffenseControl.OFFENSECONTROLGOOD_COLS));
        offenseControlBadEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, OffenseControl.OFFENSECONTROLBAD_COLS));
        entriesEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Offense.ENTRIES_COLS));
        controlledEntriesEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Entries.CONTROLLEDENTRIES_COLS));
        controlledEntriesGoodEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, ControlledEntries.CONTROLLEDENTRIESGOOD_COLS));
        controlledEntriesBadEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, ControlledEntries.CONTROLLEDENTRIESBAD_COLS));
        uncontrolledEntriesEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Entries.UNCONTROLLEDENTRIES_COLS));
        uncontrolledEntriesGoodEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, UncontrolledEntries.UNCONTROLLEDENTRIESGOOD_COLS));
        uncontrolledEntriesBadEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, UncontrolledEntries.UNCONTROLLEDENTRIESBAD_COLS));
        offenseWithoutPuckEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Offense.OFFENSEWITHOUTPUCK_COLS));
        offenseAttackEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Offense.OFFENSEATTACK_COLS));      
        offenseAttackGoodEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, OffenseAttack.OFFENSEATTACKGOOD_COLS));
        offenseAttackBadEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, OffenseAttack.OFFENSEATTACKBAD_COLS));
        defenseEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, TeamStats.DEFENSE_COLS));
        defensiveZoneDefenseEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Defense.DEFENSIVEZONEDEFENSE_COLS));
        neutralzoneDefenseEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Defense.NEUTRALZONEDEFENSE_COLS));
        exitsEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Defense.EXITS_COLS));
        exitsGoodEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Exits.EXITSGOOD_COLS));
        exitsBadEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Exits.EXITSBAD_COLS));
        transitionEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, TeamStats.TRANSITION_COLS));
        transitionGoodEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Transition.TRANSITIONGOOD_COLS));
        transitionBadEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, Transition.TRANSITIONBAD_COLS));
        energyManagementEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, TeamStats.ENERGYMANAGEMENT_COLS));
        physicalityEvaluationForTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameForTeam2, TeamStats.PHYSICALITY_COLS));

        evaluationAgainstTeam2 = Helpers.mean(allzScoresPerGameAgainstTeam2);
        offenseEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, TeamStats.OFFENSE_COLS));
        offenseControlEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Offense.OFFENSECONTROL_COLS));
        offenseControlGoodEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, OffenseControl.OFFENSECONTROLGOOD_COLS));
        offenseControlBadEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, OffenseControl.OFFENSECONTROLBAD_COLS));
        entriesEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Offense.ENTRIES_COLS));
        controlledEntriesEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Entries.CONTROLLEDENTRIES_COLS));
        controlledEntriesGoodEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, ControlledEntries.CONTROLLEDENTRIESGOOD_COLS));
        controlledEntriesBadEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, ControlledEntries.CONTROLLEDENTRIESBAD_COLS));
        uncontrolledEntriesEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Entries.UNCONTROLLEDENTRIES_COLS));
        uncontrolledEntriesGoodEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, UncontrolledEntries.UNCONTROLLEDENTRIESGOOD_COLS));
        uncontrolledEntriesBadEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, UncontrolledEntries.UNCONTROLLEDENTRIESBAD_COLS));
        offenseWithoutPuckEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Offense.OFFENSEWITHOUTPUCK_COLS));
        offenseAttackEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Offense.OFFENSEATTACK_COLS));  
        offenseAttackGoodEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, OffenseAttack.OFFENSEATTACKGOOD_COLS));
        offenseAttackBadEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, OffenseAttack.OFFENSEATTACKBAD_COLS));
        defenseEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, TeamStats.DEFENSE_COLS));
        defensiveZoneDefenseEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Defense.DEFENSIVEZONEDEFENSE_COLS));    
        neutralzoneDefenseEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Defense.NEUTRALZONEDEFENSE_COLS));
        exitsEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Defense.EXITS_COLS));
        exitsGoodEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Exits.EXITSGOOD_COLS));
        exitsBadEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Exits.EXITSBAD_COLS));
        transitionEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, TeamStats.TRANSITION_COLS));
        transitionGoodEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Transition.TRANSITIONGOOD_COLS));
        transitionBadEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, Transition.TRANSITIONBAD_COLS));
        energyManagementEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, TeamStats.ENERGYMANAGEMENT_COLS));
        physicalityEvaluationAgainstTeam2 = Helpers.mean(Helpers.subHashMap(allzScoresPerGameAgainstTeam2, TeamStats.PHYSICALITY_COLS));

        evaluationTeam2 = (evaluationForTeam2 + evaluationAgainstTeam2) / 2.0;
        offenseEvaluationTeam2 = (offenseEvaluationForTeam2 + offenseEvaluationAgainstTeam2) / 2.0;
        offenseControlEvaluationTeam2 = (offenseControlEvaluationForTeam2 + offenseControlEvaluationAgainstTeam2) / 2.0;
        offenseControlGoodEvaluationTeam2 = (offenseControlGoodEvaluationForTeam2 + offenseControlGoodEvaluationAgainstTeam2) / 2.0;
        offenseControlBadEvaluationTeam2 = (offenseControlBadEvaluationForTeam2 + offenseControlBadEvaluationAgainstTeam2) / 2.0;   
        entriesEvaluationTeam2 = (entriesEvaluationForTeam2 + entriesEvaluationAgainstTeam2) / 2.0;
        controlledEntriesEvaluationTeam2 = (controlledEntriesEvaluationForTeam2 + controlledEntriesEvaluationAgainstTeam2) / 2.0;
        controlledEntriesGoodEvaluationTeam2 = (controlledEntriesGoodEvaluationForTeam2 + controlledEntriesGoodEvaluationAgainstTeam2) / 2.0;
        controlledEntriesBadEvaluationTeam2 = (controlledEntriesBadEvaluationForTeam2 + controlledEntriesBadEvaluationAgainstTeam2) / 2.0;
        uncontrolledEntriesEvaluationTeam2 = (uncontrolledEntriesEvaluationForTeam2 + uncontrolledEntriesEvaluationAgainstTeam2) / 2.0;
        uncontrolledEntriesGoodEvaluationTeam2 = (uncontrolledEntriesGoodEvaluationForTeam2 + uncontrolledEntriesGoodEvaluationAgainstTeam2) / 2.0;
        uncontrolledEntriesBadEvaluationTeam2 = (uncontrolledEntriesBadEvaluationForTeam2 + uncontrolledEntriesBadEvaluationAgainstTeam2) / 2.0;
        offenseWithoutPuckEvaluationTeam2 = (offenseWithoutPuckEvaluationForTeam2 + offenseWithoutPuckEvaluationAgainstTeam2) / 2.0;
        offenseAttackEvaluationTeam2 = (offenseAttackEvaluationForTeam2 + offenseAttackEvaluationAgainstTeam2) / 2.0;
        offenseAttackGoodEvaluationTeam2 = (offenseAttackGoodEvaluationForTeam2 + offenseAttackGoodEvaluationAgainstTeam2) / 2.0;
        offenseAttackBadEvaluationTeam2 = (offenseAttackBadEvaluationForTeam2 + offenseAttackBadEvaluationAgainstTeam2) / 2.0;
        defenseEvaluationTeam2 = (defenseEvaluationForTeam2 + defenseEvaluationAgainstTeam2) / 2.0;
        defensiveZoneDefenseEvaluationTeam2 = (defensiveZoneDefenseEvaluationForTeam2 + defensiveZoneDefenseEvaluationAgainstTeam2) / 2.0;
        neutralzoneDefenseEvaluationTeam2 = (neutralzoneDefenseEvaluationForTeam2 + neutralzoneDefenseEvaluationAgainstTeam2) / 2.0;
        exitsEvaluationTeam2 = (exitsEvaluationForTeam2 + exitsEvaluationAgainstTeam2) / 2.0;
        exitsGoodEvaluationTeam2 = (exitsGoodEvaluationForTeam2 + exitsGoodEvaluationAgainstTeam2) / 2.0;
        exitsBadEvaluationTeam2 = (exitsBadEvaluationForTeam2 + exitsBadEvaluationAgainstTeam2) / 2.0;
        transitionEvaluationTeam2 = (transitionEvaluationForTeam2 + transitionEvaluationAgainstTeam2) / 2.0;
        transitionGoodEvaluationTeam2 = (transitionGoodEvaluationForTeam2 + transitionGoodEvaluationAgainstTeam2) / 2.0;
        transitionBadEvaluationTeam2 = (transitionBadEvaluationForTeam2 + transitionBadEvaluationAgainstTeam2) / 2.0;
        energyManagementEvaluationTeam2 = (energyManagementEvaluationForTeam2 + energyManagementEvaluationAgainstTeam2) / 2.0;
        physicalityEvaluationTeam2 = (physicalityEvaluationForTeam2 + physicalityEvaluationAgainstTeam2) / 2.0;
    }

    public Object getDate() {
        
        return date;
    }

    public Object getId() {
        
        return gameId;
    }

    public Team getTeam1() {
        
        return team1;
    }

    public Team getTeam2() {
        
        return team2;
    }
    
}