package com.simon.stats.offense.offenseAttack;

import java.util.HashMap;

public class OffenseAttackBad {

    public HashMap<String, Double> stats;

    double shotsMissedNet;
    double shotsBlocked;

    public OffenseAttackBad(HashMap<String, Double> stats){
         this.stats = stats;

        System.out.println("OffenseAttackBad stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.shotsMissedNet = stats.get("Shots missed net");
        this.shotsBlocked = stats.get("Shots blocked");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}