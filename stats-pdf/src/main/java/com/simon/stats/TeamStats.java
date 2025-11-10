package com.simon.stats;

import java.nio.file.*;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.*;

import com.simon.app.Team;
import com.simon.helpers.Helpers;
import com.simon.stats.defense.Defense;
import com.simon.stats.offense.Offense;
import com.simon.stats.transition.Transition;

public class TeamStats {

    String gameId;
    Team team;
    boolean isTeamFor;
    String filepath;
    public HashMap<String, Double> aggregatedStats;
    public Offense offense;
    public Defense defense;
    public Transition transition;
    public EnergyManagement energyManagement;
    public Physicality physicality;

    public TeamStats(String gameId, Team team, boolean isTeamFor, String filepath) throws IOException{
        this.gameId = gameId;
        this.team = team;
        this.isTeamFor = isTeamFor;
        this.filepath = filepath;
        this.aggregatedStats = aggregate(filepath);

        System.out.println("\nAll stats:\n");
        aggregatedStats.forEach((k,v) -> System.out.println(k + " = " + v));

        System.out.println("\n\n\nBuilding offense: \n");
        this.offense = new Offense(Helpers.subHashMap(aggregatedStats, OFFENSE_COLS));

        System.out.println("\n\n\nBuilding defense: \n");
        this.defense = new Defense(Helpers.subHashMap(aggregatedStats, DEFENSE_COLS));

        System.out.println("\n\n\nBuilding transition: \n");
        this.transition = new Transition(Helpers.subHashMap(aggregatedStats, TRANSITION_COLS));

        System.out.println("\n\n\nBuilding energyManagement: \n");
        this.energyManagement = new EnergyManagement(Helpers.subHashMap(aggregatedStats, ENERGYMANAGEMENT_COLS));

        System.out.println("\n\n\nBuilding physicality: \n");
        this.physicality = new Physicality(Helpers.subHashMap(aggregatedStats, PHYSICALITY_COLS));
    }

    /**
     * Agrège un CSV:
     * - Ligne 0 = en-têtes
     * - Lignes 1..N = valeurs à agréger
     * - Ignore colonnes 0..4
     * - Convertit certaines colonnes "temps" en secondes
     * - Fait la moyenne pour certaines colonnes "à moyenne", sinon somme
     * - Retourne Map<header, double>
     */

    // Délimiteur de ton fichier
    private static final String SEP = ";";

    // Colonnes "temps" -> converties en secondes (double)
    private static final Set<String> TIME_COLS = Set.of(
        "Possession time  OZ",
        "Possession time  DZ",
        "Possession time  NZ",
        "Possession time",
        "Avg. shift length",
        "Avg. rest time"
    );

    // Colonnes à MOYENNER (les autres: SOMME)
    private static final Set<String> AVERAGE_COLS = Set.of(
        "Scoring chances / shots",
        "Passing accuracy OZ  %",
        "Time per possession  OZ",
        "Giveaways OZ  %",
        "Passing accuracy DZ  %",
        "Controlled exits  %",
        "Time per possession  DZ",
        "Giveaways DZ  %",
        "Passing accuracy NZ  %",
        "Time per possession  NZ",
        "Giveaways NZ  %",
        "Controlled entries  %",
        "Avg. shift length",
        "Avg. rest time",
        "xA",
        "xA secondary",
        "Passing accuracy  %",
        "Rebound recoveries  %",
        "Giveaways  %",
        "Time per possession",
        "Faceoffs won  %",
        "xG %",
        "xG",
        "xG per 20",
        "xG from danger zone",
        "xG behind the net against",
        "xG CL against"
    );

    public static final Set<String> OFFENSE_COLS = Set.of(
        "Puck recoveries  OZ",
        "Rebound recoveries  OZ",
        "Interceptions  OZ",
        "Shot attempts from danger zone",
        "Shots with rebound",			
        "Shot attempts",	
        "Shots on goal from danger zone",		
        "Scoring chances",	
        "Scoring chances / shots",	
        "Goals from danger zone",
        "Goals",	
        "One timer goals",
        "Goals after rebounds",
        "Shots missed net",
        "Shots blocked",
        "Successful passes  OZ",
        "Passing accuracy OZ  %",
        "Time per possession  OZ",
        "Number of possessions  OZ",
        "Possession time  OZ",
        "Unsuccessful passes  OZ",
        "Giveaways  OZ",
        "Giveaways OZ  %",
        "Dispossessed  OZ",
        "Successful controlled entries",		
        "Pass in entries",	
        "Carry in entries",	
        "Controlled entries  %",
        "Failed controlled entries",
        "Successful uncontrolled entries",	
        "Dump in entries",
        "Failed uncontrolled entries"
    );

    public static final Set<String> DEFENSE_COLS = Set.of(
        "Successful passes  DZ",	
        "Passing accuracy DZ  %", 
        "Successful controlled exits",	
        "Successful uncontrolled exits",		
        "Carry out exits",	
        "Dump out exits",	
        "Pass out exits",	 
        "Controlled exits  %",	
        "Time per possession  DZ", 
        "Number of possessions  DZ", 
        "Possession time  DZ",
        "Failed uncontrolled exits",	
        "Failed controlled exits", 
        "Unsuccessful passes  DZ",
        "Giveaways  DZ",
        "Giveaways DZ  %",
        "Dispossessed  DZ",
        "Blocked shots",
        "Puck recoveries  DZ",
        "Rebound recoveries  DZ",
        "Interceptions  DZ",
        "Interceptions  NZ",
        "Puck recoveries  NZ",
        "Rebound recoveries  NZ"
    );

    public static final Set<String> TRANSITION_COLS = Set.of(
        "Passing accuracy NZ  %",		
        "Successful passes  NZ",
        "Time per possession  NZ",
        "Number of possessions  NZ",	
        "Possession time  NZ",
        "Unsuccessful passes  NZ",
        "Giveaways NZ  %",	
        "Giveaways  NZ",
        "Dispossessed  NZ"
    );

    public static final Set<String> ENERGYMANAGEMENT_COLS = Set.of(
        "Avg. shift length",
        "Avg. rest time",
        "Hit taken"
    );

    public static final Set<String> PHYSICALITY_COLS = Set.of(
        "Stick & body checks",
        "Hit delivered"
    );

    /** Agrège le CSV -> Map<header, double> */
    private HashMap<String, Double> aggregate(String filepath) throws IOException {
        // Lis en Windows-1252 (Excel Windows), sinon change par UTF-8 si besoin
        List<String> lines = Files.readAllLines(Paths.get(filepath), Charset.forName("windows-1252"));


        // 1) En-têtes (ligne 0)
        String[] headers = lines.get(0).split(SEP, -1);
        // On construit la liste d'indices à garder (ignorer 0..4)
        List<Integer> keptIdx = new ArrayList<>();
        for (int c = 5; c < headers.length; c++) keptIdx.add(c);

        // 2) Prépare les sommes et compteurs
        LinkedHashMap<String, Double> sums = new LinkedHashMap<>();
        HashMap<String, Integer> counts = new HashMap<>();

        // Initialiser l’ordre (préserve l’ordre des colonnes conservées)
        for (int c : keptIdx) {
            String h = headers[c].trim();
            if (!h.isEmpty()) {
                sums.put(h, 0.0);
                if (AVERAGE_COLS.contains(h)) counts.put(h, 0);
            }
        }

        // 3) Parcours des lignes 2..N car on ne veut pas l'en-tête ni la ligne 1 (stats de l'équipe)
        for (int r = 2; r < lines.size(); r++) {
            String[] cols = lines.get(r).split(SEP, -1);
            for (int c : keptIdx) {
                if (c >= cols.length) continue;
                String header = headers[c].trim();
                if (header.isEmpty()) continue;

                String raw = cols[c].trim();
                Double val = parseValue(header, raw);
                if (val == null) continue; // vide / non parsable

                // cumule la somme
                sums.put(header, sums.get(header) + val);

                if (AVERAGE_COLS.contains(header)) {
                    if (val != 0.0) { // on ignore les zéros
                        counts.put(header, counts.getOrDefault(header, 0) + 1);
                    }
                }
            }
        }

        // 4) Finalise (moyenne ou somme)
        HashMap<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Double> e : sums.entrySet()) {
            String h = e.getKey();
            double sum = e.getValue();
            if (AVERAGE_COLS.contains(h)) {
                int n = counts.getOrDefault(h, 0);
                result.put(h, n > 0 ? sum / n : 0.0);
            } else {
                result.put(h, sum);
            }
        }
        return result;
    }

    /** Convertit une cellule en double selon le type de colonne */
    private static Double parseValue(String header, String raw) {
        if (raw.isEmpty()) return null;

        // Colonnes temps -> secondes
        if (TIME_COLS.contains(header)) {
            Double sec = timeToSeconds(raw);
            return sec; // null si format inconnu
        }

        // Sinon: nombre (peut contenir %)
        String cleaned = raw.replace("%", "").trim();
        cleaned = cleaned.replace(',', '.'); // au cas où
        try {
            return Double.parseDouble(cleaned);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Double timeToSeconds(String s) {
        String t = s.trim();

        // si déjà un nombre (ex: "123.4"), on retourne tel quel
        try { return Double.parseDouble(t.replace(',', '.')); }
        catch (NumberFormatException ignore) {}

        // formats "mm:ss" ou "mm:ss:…", on ignore tout après les secondes
        String[] p = t.split(":");
        if (p.length < 2) return null; // format inconnu

        try {
            int mm = Integer.parseInt(p[0].trim());
            int ss = Integer.parseInt(p[1].trim()); // on ignore p[2], p[3], etc.
            return mm * 60.0 + ss;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean getIsTeamFor(){
        return isTeamFor;
    }

    public HashMap<String, Double> getAggregatedStats(){
        return aggregatedStats;
    }
}