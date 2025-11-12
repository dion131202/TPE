package com.simon.stats.offense.entries.controlledEntries;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;

public class ControlledEntries {

    public HashMap<String, Double> stats;

    public ControlledEntriesGood controlledEntriesGood;
    public ControlledEntriesBad controlledEntriesBad;

    public ControlledEntries(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("ControlledEntries stats: \n");

        System.out.println("\n\n\nBuilding offense -> Entries -> ControlledEntries -> ControlledEntriesGood\n");
        this.controlledEntriesGood = new ControlledEntriesGood(Helpers.subHashMap(stats, CONTROLLEDENTRIESGOOD_COLS));

        System.out.println("\n\n\nBuilding offense -> Entries -> ControlledEntries -> ControlledEntriesBad\n");
        this.controlledEntriesBad = new ControlledEntriesBad(Helpers.subHashMap(stats, CONTROLLEDENTRIESBAD_COLS));
    }

    public static final Set<String> CONTROLLEDENTRIESGOOD_COLS = Set.of(
        "Successful controlled entries",		
        "Pass in entries",	
        "Carry in entries",	
        "Controlled entries  %"
    );

    public static final Set<String> CONTROLLEDENTRIESBAD_COLS = Set.of(
        "Failed controlled entries"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}