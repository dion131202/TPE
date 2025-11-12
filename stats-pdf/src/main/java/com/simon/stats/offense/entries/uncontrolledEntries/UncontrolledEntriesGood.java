package com.simon.stats.offense.entries.uncontrolledEntries;

import java.util.HashMap;

public class UncontrolledEntriesGood {

    public HashMap<String, Double> stats;

    double successfulUncontrolledEntries;
    double dumpInEntries;

    public UncontrolledEntriesGood(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("UncontrolledEntriesGood stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.successfulUncontrolledEntries = stats.get("Successful uncontrolled entries");
        this.dumpInEntries = stats.get("Dump in entries");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}