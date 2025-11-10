package com.simon.stats.defense.exits;

import java.util.HashMap;

public class ExitsGood {

    HashMap<String, Double> stats;

    double successfulPassesDZ;
    double passingAccuracyDZPct;
    double successfulControlledExits;
    double successfulUncontrolledExits;
    double carryOutExits; 
    double dumpOutExits;
    double passOutExits;
    double controlledExitsPct;
    double timePerPossessionDZ;
    double numberOfPossessionsDZ;
    double possessionTimeDZ;

    public ExitsGood(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("ExitsGood stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.successfulPassesDZ = stats.get("Successful passes  DZ");
        this.passingAccuracyDZPct = stats.get("Passing accuracy DZ  %");
        this.successfulControlledExits = stats.get("Successful controlled exits");
        this.successfulUncontrolledExits = stats.get("Successful uncontrolled exits");
        this.carryOutExits = stats.get("Carry out exits");
        this.dumpOutExits = stats.get("Dump out exits");
        this.passOutExits = stats.get("Pass out exits");
        this.controlledExitsPct = stats.get("Controlled exits  %");
        this.timePerPossessionDZ = stats.get("Time per possession  DZ");
        this.numberOfPossessionsDZ = stats.get("Number of possessions  DZ");
        this.possessionTimeDZ = stats.get("Possession time  DZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}