package com.simon.stats.defense.exits;

import java.util.HashMap;

public class ExitsBad {

    public HashMap<String, Double> stats;

    double failedUncontrolledExits;
    double failedControlledExits;
    double unsuccessfulPassesDZ;
    double giveawaysDZ;
    double giveAwayDZPct;
    double dispossessedDZ;

    public ExitsBad(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("ExitsBad stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.failedUncontrolledExits = stats.get("Failed uncontrolled exits");
        this.failedControlledExits = stats.get("Failed controlled exits");
        this.unsuccessfulPassesDZ = stats.get("Unsuccessful passes  DZ");
        this.giveawaysDZ = stats.get("Giveaways  DZ");
        this.giveAwayDZPct = stats.get("Giveaways DZ  %");
        this.dispossessedDZ = stats.get("Dispossessed  DZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}