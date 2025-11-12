package com.simon.stats.transition;

import java.util.HashMap;

public class TransitionBad {

    public HashMap<String, Double> stats;

    double unsuccessfulPassesNZ;
    double giveAwayNZPct;
    double giveawaysNZ;
    double dispossessedNZ;

    public TransitionBad(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("TransitionBad stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.unsuccessfulPassesNZ = stats.get("Unsuccessful passes  NZ");
        this.giveAwayNZPct = stats.get("Giveaways NZ  %");
        this.giveawaysNZ = stats.get("Giveaways  NZ");
        this.dispossessedNZ = stats.get("Dispossessed  NZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}