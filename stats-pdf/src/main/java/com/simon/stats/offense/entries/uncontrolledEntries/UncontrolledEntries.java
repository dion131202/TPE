package com.simon.stats.offense.entries.uncontrolledEntries;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;

public class UncontrolledEntries {

    HashMap<String, Double> stats;

    UncontrolledEntriesGood uncontrolledEntriesGood;
    UncontrolledEntriesBad uncontrolledEntriesBad;

    public UncontrolledEntries(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("UncontrolledEntries stats: \n");

        System.out.println("\n\n\nBuilding offense -> Entries -> UncontrolledEntries -> UncontrolledEntriesGood\n");
        this.uncontrolledEntriesGood = new UncontrolledEntriesGood(Helpers.subHashMap(stats, UNCONTROLLEDENTRIESGOOD_COLS));

        System.out.println("\n\n\nBuilding offense -> Entries -> UncontrolledEntriesBad\n");
        this.uncontrolledEntriesBad = new UncontrolledEntriesBad(Helpers.subHashMap(stats, UNCONTROLLEDENTRIESBAD_COLS));
    }

    public static final Set<String> UNCONTROLLEDENTRIESGOOD_COLS = Set.of(
        "Successful uncontrolled entries",	
        "Dump in entries"
    );

    public static final Set<String> UNCONTROLLEDENTRIESBAD_COLS = Set.of(
        "Failed uncontrolled entries"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}
