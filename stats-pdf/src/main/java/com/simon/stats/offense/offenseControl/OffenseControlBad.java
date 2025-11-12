package com.simon.stats.offense.offenseControl;

import java.util.HashMap;

public class OffenseControlBad {

    public HashMap<String, Double> stats;

    double unsuccessfulPassesOZ;
    double giveawaysOZ;
    double giveAwayOZPct;
    double dispossessedOZ;

    public OffenseControlBad(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("OffenseControlBad stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.unsuccessfulPassesOZ = stats.get("Unsuccessful passes  OZ");
        this.giveawaysOZ = stats.get("Giveaways  OZ");
        this.giveAwayOZPct = stats.get("Giveaways OZ  %");
        this.dispossessedOZ = stats.get("Dispossessed  OZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}