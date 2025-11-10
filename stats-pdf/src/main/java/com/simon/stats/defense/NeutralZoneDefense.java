package com.simon.stats.defense;

import java.util.HashMap;

public class NeutralZoneDefense {

    HashMap<String, Double> stats;

    double interceptionsNZ;
    double puckRecoveriesNZ;
    double reboundRecoveriesNZ;

    public NeutralZoneDefense(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("NeutralZoneDefense stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.interceptionsNZ = stats.get("Interceptions  NZ");
        this.puckRecoveriesNZ = stats.get("Puck recoveries  NZ");
        this.reboundRecoveriesNZ = stats.get("Rebound recoveries  NZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}