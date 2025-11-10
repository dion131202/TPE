package com.simon.stats.offense.offenseAttack;

import java.util.HashMap;
import java.util.Set;

import com.simon.helpers.Helpers;

public class OffenseAttack {

    HashMap<String, Double> stats;

    public OffenseAttackGood offenseAttackGood;
    OffenseAttackBad offenseAttackBad;

    public OffenseAttack(HashMap<String, Double> stats){
        this.stats = stats;

        System.out.println("OffenseAttack stats: \n");

        System.out.println("\n\n\nBuilding offense -> OffenseAttack -> OffenseAttackGood\n");
        this.offenseAttackGood = new OffenseAttackGood(Helpers.subHashMap(stats, OFFENSEATTACKGOOD_COLS));

        System.out.println("\n\n\nBuilding offense -> OffenseAttack -> OffenseAttackBad\n");
        this.offenseAttackBad = new OffenseAttackBad(Helpers.subHashMap(stats, OFFENSEATTACKBAD_COLS));
    }

    public static final Set<String> OFFENSEATTACKGOOD_COLS = Set.of(
        "Shot attempts from danger zone",
        "Shots with rebound",			
        "Shot attempts",	
        "Shots on goal from danger zone",		
        "Scoring chances",	
        "Scoring chances / shots",	
        "Goals from danger zone",
        "Goals",	
        "One timer goals",
        "Goals after rebounds"
    );

    public static final Set<String> OFFENSEATTACKBAD_COLS = Set.of(
        "Shots missed net",
        "Shots blocked"
    );

    public HashMap<String, Double> getStats(){
        return stats;
    }
}