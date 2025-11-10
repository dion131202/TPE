package com.simon.stats.offense.entries;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;
import com.simon.stats.offense.entries.controlledEntries.ControlledEntries;
import com.simon.stats.offense.entries.uncontrolledEntries.UncontrolledEntries;

public class Entries {

    HashMap<String, Double> stats;

    ControlledEntries controlledEntries;
    UncontrolledEntries uncontrolledEntries;

    public Entries(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("Entries stats: \n");

        System.out.println("\n\n\nBuilding offense -> Entries -> ControlledEntries\n");
        this.controlledEntries = new ControlledEntries(Helpers.subHashMap(stats, CONTROLLEDENTRIES_COLS));

        System.out.println("\n\n\nBuilding offense -> Entries -> UncontrolledEntries\n");
        this.uncontrolledEntries = new UncontrolledEntries(Helpers.subHashMap(stats, UNCONTROLLEDENTRIES_COLS));   
    }

    public static final Set<String> CONTROLLEDENTRIES_COLS = Set.of(
        "Successful controlled entries",		
        "Pass in entries",	
        "Carry in entries",	
        "Controlled entries  %",
        "Failed controlled entries"
    );

    public static final Set<String> UNCONTROLLEDENTRIES_COLS = Set.of(
        "Successful uncontrolled entries",	
        "Dump in entries",
        "Failed uncontrolled entries"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}