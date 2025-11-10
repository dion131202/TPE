package com.simon.stats.offense.offenseAttack;

import java.util.HashMap;

public class OffenseAttackGood {

    HashMap<String, Double> stats;

    double shotAttemptsFromDangerZone;
    double shotsWithRebounds; 
    double shotAttempts; 
    double shotsOnGoalFromDangerZone;
    double scoringChances;
    double scoringChancesPerShot;
    double goalsFromDangerZone; 
    double goals; 
    double oneTimerGoals;
    double goalsAfterRebound;

    public OffenseAttackGood(HashMap<String, Double> stats){
         this.stats = stats;

        System.out.println("OffenseAttackGood stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.shotAttemptsFromDangerZone = stats.get("Shot attempts from danger zone");
        this.shotsWithRebounds = stats.get("Shots with rebound");
        this.shotAttempts = stats.get("Shot attempts");
        this.shotsOnGoalFromDangerZone = stats.get("Shots on goal from danger zone");
        this.scoringChances = stats.get("Scoring chances");
        this.scoringChancesPerShot = stats.get("Scoring chances / shots");
        this.goalsFromDangerZone = stats.get("Goals from danger zone");
        this.goals = stats.get("Goals");
        this.oneTimerGoals = stats.get("One timer goals");
        this.goalsAfterRebound = stats.get("Goals after rebounds");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}