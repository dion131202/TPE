package com.simon.stats.offense.offenseControl;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;

public class OffenseControl {

    HashMap<String, Double> stats;

    OffenseControlGood offenseControlGood;
    OffenseControlBad offenseControlBad;

    public OffenseControl(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("OffenseControl stats: \n");

        System.out.println("\n\n\nBuilding offense -> OffenseControl -> OffenseControlGood\n");
        this.offenseControlGood = new OffenseControlGood(Helpers.subHashMap(stats, OFFENSECONTROLGOOD_COLS));

        System.out.println("\n\n\nBuilding offense -> OffenseControl -> OffenseControlBad\n");
        this.offenseControlBad = new OffenseControlBad(Helpers.subHashMap(stats, OFFENSECONTROLBAD_COLS));
    }

    public static final Set<String> OFFENSECONTROLGOOD_COLS = Set.of(
        "Successful passes  OZ",
        "Passing accuracy OZ  %",
        "Time per possession  OZ",
        "Number of possessions  OZ",
        "Possession time  OZ"
    );

    public static final Set<String> OFFENSECONTROLBAD_COLS = Set.of(
        "Unsuccessful passes  OZ",
        "Giveaways  OZ",
        "Giveaways OZ  %",
        "Dispossessed  OZ"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}