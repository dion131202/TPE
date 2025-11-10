package com.simon.stats.defense.exits;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;

public class Exits {

    HashMap<String, Double> stats;

    ExitsGood exitsGood;
    ExitsBad exitsBad;

    public Exits(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("Exits stats: \n");

        System.out.println("\n\n\nBuilding defense -> Exits -> ExitsGood\n");
        this.exitsGood = new ExitsGood(Helpers.subHashMap(stats, EXITSGOOD_COLS));

        System.out.println("\n\n\nBuilding defense -> Exits -> ExitsBad\n");
        this.exitsBad = new ExitsBad(Helpers.subHashMap(stats, EXITSBAD_COLS));
    }

    public static final Set<String> EXITSGOOD_COLS = Set.of(
        "Successful passes  DZ",	
        "Passing accuracy DZ  %", 
        "Successful controlled exits",	
        "Successful uncontrolled exits",		
        "Carry out exits",	
        "Dump out exits",	
        "Pass out exits",	 
        "Controlled exits  %",	
        "Time per possession  DZ", 
        "Number of possessions  DZ", 
        "Possession time  DZ"
    );

    public static final Set<String> EXITSBAD_COLS = Set.of(
        "Failed uncontrolled exits",	
        "Failed controlled exits", 
        "Unsuccessful passes  DZ",
        "Giveaways  DZ",
        "Giveaways DZ  %",
        "Dispossessed  DZ"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}