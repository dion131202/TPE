package com.simon.stats;

import java.util.HashMap;

public class EnergyManagement {

    public HashMap<String, Double> stats;

    double avgShiftLength;
    double avgRestTime;
    double hitTaken;

    public EnergyManagement(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("EnergyManagement stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.avgShiftLength = stats.get("Avg. shift length");
        this.avgRestTime = stats.get("Avg. rest time");
        this.hitTaken = stats.get("Hit taken");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}