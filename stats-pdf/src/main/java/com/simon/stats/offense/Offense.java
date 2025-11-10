package com.simon.stats.offense;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;
import com.simon.stats.offense.entries.Entries;
import com.simon.stats.offense.offenseAttack.OffenseAttack;
import com.simon.stats.offense.offenseControl.OffenseControl;

public class Offense{

    HashMap<String, Double> stats;
    OffenseWithoutPuck offenseWithoutPuck;
    public OffenseAttack offenseAttack;
    OffenseControl offenseControl;
    Entries entries;

    public Offense(HashMap<String, Double> stats) {

        this.stats = stats;

        System.out.println("Offense stats: \n");

        System.out.println("\n\n\nBuilding offense -> OffenseWithoutPuck\n");
        this.offenseWithoutPuck = new OffenseWithoutPuck(Helpers.subHashMap(stats, OFFENSEWITHOUTPUCK_COLS));

        System.out.println("\n\n\nBuilding offense -> OffenseAttack\n");
        this.offenseAttack = new OffenseAttack(Helpers.subHashMap(stats, OFFENSEATTACK_COLS));

        System.out.println("\n\n\nBuilding offense -> OffenseControl\n");
        this.offenseControl = new OffenseControl(Helpers.subHashMap(stats, OFFENSECONTROL_COLS));

        System.out.println("\n\n\nBuilding offense -> Entries\n");
        this.entries = new Entries(Helpers.subHashMap(stats, ENTRIES_COLS));
    }

    public static final Set<String> OFFENSEWITHOUTPUCK_COLS = Set.of(
        "Puck recoveries  OZ",
        "Rebound recoveries  OZ",
        "Interceptions  OZ"
    );

    public static final Set<String> OFFENSEATTACK_COLS = Set.of(
        "Shot attempts from danger zone",
        "Shots with rebound",			
        "Shot attempts",	
        "Shots on goal from danger zone",		
        "Scoring chances",	
        "Scoring chances / shots",	
        "Goals from danger zone",
        "Goals",	
        "One timer goals",
        "Goals after rebounds",
        "Shots missed net",
        "Shots blocked"
    );

    public static final Set<String> OFFENSECONTROL_COLS = Set.of(
        "Successful passes  OZ",
        "Passing accuracy OZ  %",
        "Time per possession  OZ",
        "Number of possessions  OZ",
        "Possession time  OZ",
        "Unsuccessful passes  OZ",
        "Giveaways  OZ",
        "Giveaways OZ  %",
        "Dispossessed  OZ"
    );

    public static final Set<String> ENTRIES_COLS = Set.of(
        "Successful controlled entries",		
        "Pass in entries",	
        "Carry in entries",	
        "Controlled entries  %",
        "Failed controlled entries",
        "Successful uncontrolled entries",	
        "Dump in entries",
        "Failed uncontrolled entries"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}