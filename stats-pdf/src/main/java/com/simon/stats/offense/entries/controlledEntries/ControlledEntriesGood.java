package com.simon.stats.offense.entries.controlledEntries;

import java.util.HashMap;

public class ControlledEntriesGood {

    HashMap<String, Double> stats;

    double successfulControlledEntries;
    double passInEntries; 
    double carryInEntries;
    double controlledEntriesPct;

    public ControlledEntriesGood(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("ControlledEntriesGood stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.successfulControlledEntries = stats.get("Successful controlled entries");
        this.passInEntries = stats.get("Pass in entries");
        this.carryInEntries = stats.get("Carry in entries");
        this.controlledEntriesPct = stats.get("Controlled entries  %");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}