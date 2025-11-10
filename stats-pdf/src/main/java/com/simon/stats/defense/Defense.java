package com.simon.stats.defense;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;
import com.simon.stats.defense.exits.Exits;

public class Defense {

    HashMap<String, Double> stats;
    Exits exits;
    DefensiveZoneDefense defensiveZoneDefense;
    NeutralZoneDefense neutralZoneDefense;

    public Defense(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("Defense stats: \n");

        System.out.println("\n\n\nBuilding defense -> Exits\n");
        this.exits = new Exits(Helpers.subHashMap(stats, EXITS_COLS));

        System.out.println("\n\n\nBuilding defense -> DefensiveZoneDefense\n");
        this.defensiveZoneDefense = new DefensiveZoneDefense(Helpers.subHashMap(stats, DEFENSIVEZONEDEFENSE_COLS));

        System.out.println("\n\n\nBuilding defense -> NeutralZoneDefense\n");
        this.neutralZoneDefense = new NeutralZoneDefense(Helpers.subHashMap(stats, NEUTRALZONEDEFENSE_COLS));
    }

    public static final Set<String> EXITS_COLS = Set.of(
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
        "Possession time  DZ",
        "Failed uncontrolled exits",	
        "Failed controlled exits", 
        "Unsuccessful passes  DZ",
        "Giveaways  DZ",
        "Giveaways DZ  %",
        "Dispossessed  DZ"
    );

    public static final Set<String> DEFENSIVEZONEDEFENSE_COLS = Set.of(
        "Blocked shots",
        "Puck recoveries  DZ",
        "Rebound recoveries  DZ",
        "Interceptions  DZ"
    );

    public static final Set<String> NEUTRALZONEDEFENSE_COLS = Set.of(
        "Interceptions  NZ",
        "Puck recoveries  NZ",
        "Rebound recoveries  NZ"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}