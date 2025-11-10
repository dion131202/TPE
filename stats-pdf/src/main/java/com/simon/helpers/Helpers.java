package com.simon.helpers;

import java.util.*;

import com.simon.stats.TeamStats;

public final class Helpers{

    private static final Set<String> BAD_COLS = new HashSet<>(Arrays.asList(
        "Unsuccessful passes  OZ",
        "Giveaways  OZ",
        "Giveaways OZ  %",
        "Dispossessed  OZ",
        "Shots missed net",
        "Shots blocked",
        "Failed controlled entries",
        "Failed uncontrolled entries",
        "Unsuccessful passes  NZ",
        "Giveaways NZ  %",	
        "Giveaways  NZ",
        "Dispossessed  NZ",
        "Failed uncontrolled exits",	
        "Failed controlled exits", 
        "Unsuccessful passes  DZ",
        "Giveaways  DZ",
        "Giveaways DZ  %",
        "Dispossessed  DZ",
        "Avg. shift length",
        "Hit taken"
    ));

    // Build a sub-HashMap
    public static final HashMap<String, Double> subHashMap(HashMap<String, Double> hashMap, Set<String> wantedValues) {
        HashMap<String, Double> subHashMap = new HashMap<>();
        for (Map.Entry<String, Double> e : hashMap.entrySet()) {
            if (wantedValues.contains(e.getKey())) {
                subHashMap.put(e.getKey(), e.getValue());
            }
        }
        return subHashMap;
    }

    public static HashMap<String, Double> meanPerStats(ArrayList<TeamStats> games) {
        int G = games.size();
        HashMap<String, Double> meanMap = new HashMap<>();
        if (G == 0) return meanMap;

        // Récupère la première map comme "schéma" (mêmes clés / même ordre pour toutes)
        Map<String, Double> first = games.get(0).getAggregatedStats();
        List<String> keys = new ArrayList<>(first.keySet()); // on fige l'ordre des clés

        int K = keys.size();
        double[] mean = new double[K];
    
        // Moyennes par clé
        for (int j = 0; j < K; j++) {
            String k = keys.get(j);
            double sum = 0.0;
            for (int i = 0; i < G; i++) {
                double v = games.get(i).getAggregatedStats().get(k);
                sum += v;
            }
            mean[j] = sum / G;
            meanMap.put(k, mean[j]);
        }
    
        return meanMap;
    }

    public static HashMap<String, Double> stdDevPerStats(ArrayList<TeamStats> games, HashMap<String, Double> meanMap) {
        int G = games.size();
        HashMap<String, Double> stdDevMap = new HashMap<>();
        if (G == 0) return stdDevMap;

        // Récupère la première map comme "schéma" (mêmes clés / même ordre pour toutes)
        Map<String, Double> first = games.get(0).getAggregatedStats();
        List<String> keys = new ArrayList<>(first.keySet()); // on fige l'ordre des clés

        int K = keys.size();
        double[] std  = new double[K];

        // Écarts-types (non biaisés) par clé
        for (int j = 0; j < K; j++) {
            String k = keys.get(j);
            double mu = meanMap.get(k);
            double acc = 0.0;
            for (int i = 0; i < G; i++) {
                double v = games.get(i).getAggregatedStats().get(k);
                double d = v - mu;
                acc += d * d;
            }
            std[j] = (G > 1) ? Math.sqrt(acc / (G - 1)) : 0.0;
            stdDevMap.put(k, std[j]);
        }

        return stdDevMap;
    }
    
    public static HashMap<String, Double> zScoresPerGame(HashMap<String, Double> stats, HashMap<String, Double> meanMap, HashMap<String, Double> stdDevMap) {
    
        double mu;
        double sigma;
        HashMap<String, Double> zmap = new HashMap<>();

        for (Map.Entry<String, Double> e : stats.entrySet()) {
            String k = e.getKey();
            double v = e.getValue();
            if(meanMap != null){
                mu = meanMap.get(k);
            }
            else{
                mu = 0.0;
            }
            if(stdDevMap != null){
                sigma = stdDevMap.get(k);
            }
            else{
                sigma = 0.0;
            }
            double z = (sigma > 0.0) ? (v - mu) / sigma : 0.0;

            // bornage [-3,3]
            if (z < -3.0) z = -3.0;
            else if (z > 3.0) z = 3.0;

            // si "mauvaise" colonne, on inverse le signe : plus c'est grand, plus c'est "mauvais" => score négatif
            if (BAD_COLS.contains(k)) {
                z = -z;
            }
            // mapping linéaire vers [-1, 1] (z ∈ [-3,3] -> s ∈ [-1,1])
            double s = z / 3.0;

            zmap.put(k, s); 
        }

        return zmap;
    }

    public static double mean(HashMap<String, Double> zmap) {
        double sum = 0.0;
        for (double v : zmap.values()) sum += v;
        return sum / zmap.size();
    }

}