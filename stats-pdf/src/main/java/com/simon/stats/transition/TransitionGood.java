package com.simon.stats.transition;

import java.util.HashMap;

public class TransitionGood {

    public HashMap<String, Double> stats;

    double passingAccuracyNZPct;
    double successfulPassesNZ;
    double timePerPossessionNZ;
    double numberOfPossessionsNZ;
    double possessionTimeNZ;

    public TransitionGood(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("TransitionGood stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.passingAccuracyNZPct = stats.get("Passing accuracy NZ  %");
        this.successfulPassesNZ = stats.get("Successful passes  NZ");
        this.timePerPossessionNZ = stats.get("Time per possession  NZ");
        this.numberOfPossessionsNZ = stats.get("Number of possessions  NZ");
        this.possessionTimeNZ = stats.get("Possession time  NZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}