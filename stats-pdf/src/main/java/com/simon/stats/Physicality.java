package com.simon.stats;

import java.util.HashMap;

public class Physicality {
    public HashMap<String, Double> stats;
    double stickAndBodyChecks; 
    double hitDelivered;

    public Physicality(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("Physicality stats: \n");
        stats.forEach((k,v) -> System.out.println(k + " = " + v));

        this.stickAndBodyChecks = stats.get("Stick & body checks");
        this.hitDelivered = stats.get("Hit delivered");
    }

    public HashMap<String, Double> getStats(){
        return stats;
    }
}