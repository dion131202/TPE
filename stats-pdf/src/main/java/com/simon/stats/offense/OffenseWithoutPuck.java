package com.simon.stats.offense;

import java.util.HashMap;

public class OffenseWithoutPuck {

    HashMap<String, Double> stats;

    double puckRecoveriesOZ;
    double reboundRecoveriesOZ;
    double interceptionsOZ;

    public OffenseWithoutPuck(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("OffenseWithoutPuck stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.puckRecoveriesOZ = stats.get("Puck recoveries  OZ");
        this.reboundRecoveriesOZ = stats.get("Rebound recoveries  OZ");
        this.interceptionsOZ = stats.get("Interceptions  OZ");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}