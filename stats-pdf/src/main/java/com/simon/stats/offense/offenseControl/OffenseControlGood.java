package com.simon.stats.offense.offenseControl;

import java.util.HashMap;

public class OffenseControlGood {

    public HashMap<String, Double> stats;

    double successfulPassesOZ;
    double passingAccuracyOZPct;
    double timePerPossessionOZ;
    double numberOfPossessionsOZ;
    double possessionTimeOZ;

    public OffenseControlGood(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("OffenseControlGood stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.successfulPassesOZ = stats.get("Successful passes  OZ");
        this.passingAccuracyOZPct = stats.get("Passing accuracy OZ  %");
        this.timePerPossessionOZ = stats.get("Time per possession  OZ");
        this.numberOfPossessionsOZ = stats.get("Number of possessions  OZ");
        this.possessionTimeOZ = stats.get("Possession time  OZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}