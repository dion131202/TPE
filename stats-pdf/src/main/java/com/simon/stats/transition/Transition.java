package com.simon.stats.transition;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;

public class Transition {

    HashMap<String, Double> stats;
    TransitionBad transitionBad;
    TransitionGood transitionGood;

    public Transition(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("Transition stats: \n");

        System.out.println("\n\n\nBuilding transition -> TransitionGood\n");
        this.transitionGood = new TransitionGood(Helpers.subHashMap(stats, TRANSITIONGOOD_COLS));

        System.out.println("\n\n\nBuilding transition -> TransitionBad\n");
        this.transitionBad = new TransitionBad(Helpers.subHashMap(stats, TRANSITIONBAD_COLS));
    }

    public static final Set<String> TRANSITIONGOOD_COLS = Set.of(
        "Passing accuracy NZ  %",		
        "Successful passes  NZ",
        "Time per possession  NZ",
        "Number of possessions  NZ",	
        "Possession time  NZ"
    );

    public static final Set<String> TRANSITIONBAD_COLS = Set.of(
        "Unsuccessful passes  NZ",
        "Giveaways NZ  %",	
        "Giveaways  NZ",
        "Dispossessed  NZ"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}

