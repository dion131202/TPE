package com.simon.stats.defense;

import java.util.HashMap;

public class DefensiveZoneDefense {

    HashMap<String, Double> stats;

    double blockedShots;
    double puckRecoveriesDZ;
    double reboundRecoveriesDZ;
    double interceptionsDZ;

    public DefensiveZoneDefense(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("DefensiveZoneDefense stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.blockedShots = stats.get("Blocked shots");
        this.puckRecoveriesDZ = stats.get("Puck recoveries  DZ");
        this.reboundRecoveriesDZ = stats.get("Rebound recoveries  DZ");
        this.interceptionsDZ = stats.get("Interceptions  DZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}