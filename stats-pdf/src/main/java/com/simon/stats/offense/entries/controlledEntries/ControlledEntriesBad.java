package com.simon.stats.offense.entries.controlledEntries;

import java.util.HashMap;

public class ControlledEntriesBad {

    public HashMap<String, Double> stats;

    double failedControlledEntries;

    public ControlledEntriesBad(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("ControlledEntriesBad stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.failedControlledEntries = stats.get("Failed controlled entries");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}