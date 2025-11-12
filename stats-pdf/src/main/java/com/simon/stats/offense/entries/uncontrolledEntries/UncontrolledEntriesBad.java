package com.simon.stats.offense.entries.uncontrolledEntries;

import java.util.HashMap;

public class UncontrolledEntriesBad {

    public HashMap<String, Double> stats;

    double failedUncontrolledEntries;

    public UncontrolledEntriesBad(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("UncontrolledEntriesBad stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.failedUncontrolledEntries = stats.get("Failed uncontrolled entries");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}