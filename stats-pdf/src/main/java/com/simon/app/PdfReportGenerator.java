package com.simon.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Color;

public final class PdfReportGenerator {

    private PdfReportGenerator() {}

    public static Path generateGameReport(String fileName, String gameId, String teamSide, League league) throws IOException {
        if (!fileName.toLowerCase(Locale.ROOT).endsWith(".pdf")) fileName = fileName + ".pdf";

        Path out = Paths.get("target", "reports", fileName);
        Files.createDirectories(out.getParent());

        Game game = findGameById(league, gameId);
        if (game == null) throw new IllegalArgumentException("Game not found: " + gameId);

        Team team = pickTeam(game, teamSide);
        if (team == null) throw new IllegalArgumentException("teamSide must be \"team1\" or \"team2\".");

        boolean isTeam1 = "team1".equalsIgnoreCase(teamSide);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
        nf.setMaximumFractionDigits(2);

        try (PDDocument doc = new PDDocument()) {

            // =================== PAGE 1 : PRÉSENTATION (inchangée) ===================
            PDPage cover = new PDPage(PDRectangle.LETTER);
            doc.addPage(cover);
            try (PDPageContentStream cs = new PDPageContentStream(doc, cover)) {
                float margin = 60f;
                float y = cover.getMediaBox().getHeight() - margin;
                y = writeTitle(cs, "Rapport de Match — " + team.getName() + " " + game.getDate(), margin, y);
                y -= 10f;
                y -= 8f;
                y = writeLine(cs, "Adversaire : " + opponentName(game, team), margin, y, 11, false);
            }

            // =================== PAGE 2 : OFFENSE ===================
            {
                PDPage page = new PDPage(PDRectangle.LETTER);
                doc.addPage(page);
                try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                    float margin = 48f;
                    float y = page.getMediaBox().getHeight() - margin;

                    y = bigSectionHeader(cs, "Offense", margin, y);

                    // lignes (libellé + barre score)
                    y = scoreRow(cs, page, margin, y, "Global offense",
                            isTeam1 ? game.offenseEvaluationTeam1 : game.offenseEvaluationTeam2, nf);

                    //y = scoreRow(cs, page, margin, y, "Offense attack",
                            //isTeam1 ? game.offenseAttackEvaluationTeam1 : game.offenseAttackEvaluationTeam2, nf);

                    y = scoreRowWithStats(cs, page, margin, y, "Offense attack",
                            isTeam1 ? game.offenseAttackEvaluationTeam1 : game.offenseAttackEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.offense.offenseAttack.offenseAttackGood.stats : game.team2StatsFor.offense.offenseAttack.offenseAttackGood.stats,   
                            isTeam1 ? game.team1StatsFor.offense.offenseAttack.offenseAttackBad.stats : game.team2StatsFor.offense.offenseAttack.offenseAttackBad.stats, 
                            game, isTeam1);

                    y = scoreRowWithStats(cs, page, margin, y, "Offense control",
                            isTeam1 ? game.offenseControlEvaluationTeam1 : game.offenseControlEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.offense.offenseControl.offenseControlGood.stats : game.team2StatsFor.offense.offenseControl.offenseControlGood.stats,   
                            null, 
                            game, isTeam1);

                    y = scoreRow(cs, page, margin, y, "Entries",
                            isTeam1 ? game.entriesEvaluationTeam1 : game.entriesEvaluationTeam2, nf);

                    y = scoreRowWithStats(cs, page, margin, y, "Controlled entries",
                            isTeam1 ? game.controlledEntriesEvaluationTeam1 : game.controlledEntriesEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.offense.entries.controlledEntries.controlledEntriesGood.stats : game.team2StatsFor.offense.entries.controlledEntries.controlledEntriesGood.stats,   
                            isTeam1 ? game.team1StatsFor.offense.entries.controlledEntries.controlledEntriesBad.stats : game.team2StatsFor.offense.entries.controlledEntries.controlledEntriesBad.stats, 
                            game, isTeam1);

                    y = scoreRowWithStats(cs, page, margin, y, "Uncontrolled entries",
                            isTeam1 ? game.uncontrolledEntriesEvaluationTeam1 : game.uncontrolledEntriesEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.offense.entries.uncontrolledEntries.uncontrolledEntriesGood.stats : game.team2StatsFor.offense.entries.uncontrolledEntries.uncontrolledEntriesGood.stats,   
                            isTeam1 ? game.team1StatsFor.offense.entries.uncontrolledEntries.uncontrolledEntriesBad.stats : game.team2StatsFor.offense.entries.uncontrolledEntries.uncontrolledEntriesBad.stats, 
                            game, isTeam1);

                    y = scoreRowWithStats(cs, page, margin, y, "Offense without puck",
                            isTeam1 ? game.offenseWithoutPuckEvaluationTeam1 : game.offenseWithoutPuckEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.offense.offenseWithoutPuck.stats : game.team2StatsFor.offense.offenseWithoutPuck.stats,   
                            null, 
                            game, isTeam1);
                }
            }

            // =================== PAGE 3 : DEFENSE ===================
            {
                PDPage page = new PDPage(PDRectangle.LETTER);
                doc.addPage(page);
                try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                    float margin = 48f;
                    float y = page.getMediaBox().getHeight() - margin;

                    y = bigSectionHeader(cs, "Defense", margin, y);

                    y = scoreRow(cs, page, margin, y, "Global defense",
                            isTeam1 ? game.defenseEvaluationTeam1 : game.defenseEvaluationTeam2, nf);

                    y = scoreRowWithStats(cs, page, margin, y, "Defensive zone defense",
                            isTeam1 ? game.defensiveZoneDefenseEvaluationTeam1 : game.defensiveZoneDefenseEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.defense.defensiveZoneDefense.stats : game.team2StatsFor.defense.defensiveZoneDefense.stats,   
                            null, 
                            game, isTeam1);

                    y = scoreRowWithStats(cs, page, margin, y, "Neutral zone defense",
                            isTeam1 ? game.neutralzoneDefenseEvaluationTeam1 : game.neutralzoneDefenseEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.defense.neutralZoneDefense.stats : game.team2StatsFor.defense.neutralZoneDefense.stats,   
                            null, 
                            game, isTeam1);

                    y = scoreRowWithStats(cs, page, margin, y, "Exits",
                            isTeam1 ? game.exitsEvaluationTeam1 : game.exitsEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.defense.exits.exitsGood.stats : game.team2StatsFor.defense.exits.exitsGood.stats,   
                            isTeam1 ? game.team1StatsFor.defense.exits.exitsBad.stats : game.team2StatsFor.defense.exits.exitsBad.stats, 
                            game, isTeam1);
                }
            }

            // =================== PAGE 4 : TRANSITION ===================
            {
                PDPage page = new PDPage(PDRectangle.LETTER);
                doc.addPage(page);
                try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                    float margin = 48f;
                    float y = page.getMediaBox().getHeight() - margin;

                    y = bigSectionHeader(cs, "Transition", margin, y);

                    y = scoreRowWithStats(cs, page, margin, y, "Global transition",
                            isTeam1 ? game.transitionEvaluationTeam1 : game.transitionEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.transition.transitionGood.stats : game.team2StatsFor.transition.transitionGood.stats,   
                            isTeam1 ? game.team1StatsFor.transition.transitionBad.stats : game.team2StatsFor.transition.transitionBad.stats, 
                            game, isTeam1);
                }
            }

            // =================== PAGE 5 : PHYSICALITÉ ===================
            {
                PDPage page = new PDPage(PDRectangle.LETTER);
                doc.addPage(page);
                try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                    float margin = 48f;
                    float y = page.getMediaBox().getHeight() - margin;

                    y = bigSectionHeader(cs, "Physicality", margin, y);

                    y = scoreRowWithStats(cs, page, margin, y, "Global physicality",
                            isTeam1 ? game.physicalityEvaluationTeam1 : game.physicalityEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.physicality.stats : game.team2StatsFor.physicality.stats,   
                            null, 
                            game, isTeam1);
                }
            }

            // =================== PAGE 6 : GESTION DE L'ÉNERGIE ===================
            {
                PDPage page = new PDPage(PDRectangle.LETTER);
                doc.addPage(page);
                try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                    float margin = 48f;
                    float y = page.getMediaBox().getHeight() - margin;

                    y = bigSectionHeader(cs, "Energy management", margin, y);

                    y = scoreRowWithStats(cs, page, margin, y, "Global energy management",
                            isTeam1 ? game.energyManagementEvaluationTeam1 : game.energyManagementEvaluationTeam2, nf,
                            isTeam1 ? game.team1StatsFor.energyManagement.stats : game.team2StatsFor.energyManagement.stats,   
                            null, 
                            game, isTeam1);
                }
            }

            doc.save(out.toFile());
        }

        return out;
    }

    // -------------------- Domaine --------------------

    private static Game findGameById(League league, String gameId) {
        for (Game g : league.getGames()) {
            if (gameId.equalsIgnoreCase(safe(g.getId()))) return g;
        }
        return null;
    }

    private static Team pickTeam(Game game, String teamSide) {
        String side = (teamSide == null) ? "" : teamSide.trim().toLowerCase(Locale.ROOT);
        switch (side) {
            case "team1": return game.getTeam1();
            case "team2": return game.getTeam2();
            default:      return null;
        }
    }

    private static String opponentName(Game game, Team team) {
        Team opp = (game.getTeam1() == team) ? game.getTeam2() : game.getTeam1();
        return opp != null ? opp.getName() : "N/A";
    }

    private static String safe(Object o) { return o == null ? "" : String.valueOf(o); }

    // -------------------- PDF helpers --------------------

    private static float writeTitle(PDPageContentStream cs, String text, float x, float y) throws IOException {
        cs.setNonStrokingColor(Color.BLACK); 
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 20);
        cs.newLineAtOffset(x, y);
        cs.showText(text);
        cs.endText();
        return y - 30f;
    }

    private static float bigSectionHeader(PDPageContentStream cs, String text, float x, float y) throws IOException {
        cs.setNonStrokingColor(Color.BLACK); 
        y -= 6f;
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 22);
        cs.newLineAtOffset(x, y);
        cs.showText(text);
        cs.endText();

        // petite ligne sous le titre
        y -= 10f;
        cs.setLineWidth(1.2f);
        cs.moveTo(x, y);
        cs.lineTo(x + 520f, y);
        cs.stroke();
        return y - 20f;
    }

    private static float writeLine(PDPageContentStream cs, String text, float x, float y, float fontSize, boolean bold) throws IOException {
        cs.setNonStrokingColor(Color.BLACK); 
        cs.beginText();
        cs.setFont(bold ? PDType1Font.HELVETICA_BOLD : PDType1Font.HELVETICA, fontSize);
        cs.newLineAtOffset(x, y);
        cs.showText(text);
        cs.endText();
        return y - (fontSize + 6f);
    }

    /**
     * Affiche une "ligne score" composée de :
     * - label (gras)
     * - barre horizontale centrée en 0
     * - valeur formatée à droite
     */
    private static float scoreRow(PDPageContentStream cs, PDPage page, float margin, float y,
                                  String label, double score, NumberFormat nf) throws IOException {
        final float rowHeight = 42f;
        final float pageWidth = page.getMediaBox().getWidth();
        final float contentWidth = pageWidth - 2 * margin;

        // 1) Label
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 18);
        cs.newLineAtOffset(margin, y);
        cs.showText(label);
        cs.endText();

        // 2) Valeur (à droite)
        String valText = nf.format(score);
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA, 12);
        float valueX = margin + contentWidth - 40f;
        cs.newLineAtOffset(valueX, y);
        cs.showText(valText);
        cs.endText();

        // 3) Barre (au milieu)
        float barX = margin + 160f;
        float barY = y - 16f;
        float barW = contentWidth - 220f; // laisse de la place au label et à la valeur
        float barH = 12f;

        drawScoreBar(cs, barX, barY, barW, barH, score);

        return y - rowHeight;
    }

    /**
     * Dessine une barre de score centrée sur 0 :
     * - fond gris clair
     * - trait milieu (0)
     * - remplissage vers la droite si score>0, vers la gauche si score<0
     * - couleur : rouge (≤-0.25), jaune (-0.25..0.25), vert (≥0.25)
     */
    private static void drawScoreBar(PDPageContentStream cs, float x, float y, float w, float h, double score) throws IOException {
        // clamp score
        double s = Math.max(-1.0, Math.min(1.0, score));
        float mid = x + w / 2f;

        // fond
        cs.setNonStrokingColor(new Color(240, 240, 240));
        cs.addRect(x, y, w, h);
        cs.fill();

        // repère 0
        cs.setStrokingColor(new Color(170, 170, 170));
        cs.setLineWidth(0.8f);
        cs.moveTo(mid, y - 2f);
        cs.lineTo(mid, y + h + 2f);
        cs.stroke();

        // contour
        cs.setStrokingColor(new Color(120, 120, 120));
        cs.setLineWidth(0.8f);
        cs.addRect(x, y, w, h);
        cs.stroke();

        // couleur selon score
        Color c = colorForScore(s);
        cs.setNonStrokingColor(c);

        // remplissage depuis le centre
        float half = w / 2f;
        float fill = (float)(Math.abs(s) * half);

        if (s > 0) {
            cs.addRect(mid, y, fill, h);
        } else if (s < 0) {
            cs.addRect(mid - fill, y, fill, h);
        } else {
            // s == 0: petit marqueur
            cs.addRect(mid - 1.5f, y, 3f, h);
        }
        cs.fill();

        // graduations -1 | 0 | 1 (petits repères)
        cs.setNonStrokingColor(new Color(100, 100, 100));
        final float notchH = 4f;
        // -1
        cs.addRect(x - 0.5f, y + h + 2f, 1f, notchH);
        // 0 (déjà un trait vertical, on ajoute juste une petite barre courte en haut)
        cs.addRect(mid - 0.5f, y + h + 2f, 1f, notchH);
        // 1
        cs.addRect(x + w - 0.5f, y + h + 2f, 1f, notchH);
        cs.fill();

        cs.setNonStrokingColor(Color.BLACK);
    }

    private static Color colorForScore(double s) {
        if (s <= -0.25) return new Color(205, 73, 69);      // rouge
        if (s >=  0.25) return new Color(66, 160, 88);      // vert
        return new Color(231, 183, 67);                     // jaune
    }

    /**
     * Même esprit que scoreRow, mais ajoute sous la barre deux colonnes de stats :
     * - leftStats (bonnes) à gauche
     * - rightStats (mauvaises) à droite
     */
    private static float scoreRowWithStats(PDPageContentStream cs, PDPage page, float margin, float y,
                                        String label, double score, NumberFormat nf,
                                        Map<String, Double> leftStats, Map<String, Double> rightStats, Game currentGameRef, boolean currentIsTeam1Ref) throws IOException {
        final float rowHeight = 42f;
        final float pageWidth = page.getMediaBox().getWidth();
        final float contentWidth = pageWidth - 2 * margin;

        // 1) Label
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 12);
        cs.newLineAtOffset(margin, y);
        cs.showText(label);
        cs.endText();

        // 2) Valeur (à droite)
        String valText = nf.format(score);
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA, 12);
        float valueX = margin + contentWidth - 40f;
        cs.newLineAtOffset(valueX, y);
        cs.showText(valText);
        cs.endText();

        // 3) Barre (au milieu)
        float barX = margin + 160f;
        float barY = y - 16f;
        float barW = contentWidth - 220f;
        float barH = 12f;

        drawScoreBar(cs, barX, barY, barW, barH, score);

        // 4) Deux colonnes de stats sous la barre
        float afterBarY = barY - 12f; // petit espace sous la barre
        float newY = drawTwoStatsColumns(cs, page, margin, afterBarY,
                                 leftStats, rightStats, nf,
                                 currentGameRef, currentIsTeam1Ref);

        // On laisse un peu d'air sous les colonnes avant l’élément suivant
        return newY - 12f;
    }

    /**
     * Dessine deux colonnes "clé : valeur" sous un score :
     * - colonne gauche = leftStats (bonnes)
     * - colonne droite = rightStats (mauvaises)
     * Retourne la nouvelle coordonnée Y après avoir écrit toutes les lignes (la plus basse des deux colonnes).
     */
    private static float drawTwoStatsColumns(PDPageContentStream cs, PDPage page, float margin, float yStart,
                                         Map<String, Double> leftStats, Map<String, Double> rightStats,
                                         NumberFormat nf,
                                         Game currentGameRef, boolean currentIsTeam1Ref) throws IOException {
        if (leftStats == null)  leftStats  = Map.of();
        if (rightStats == null) rightStats = Map.of();

        final float pageWidth = page.getMediaBox().getWidth();
        final float contentWidth = pageWidth - 2 * margin;

        // Séparation centrale
        float midX = margin + contentWidth / 2f;
        float colGap = 16f; // écart entre la barre centrale et le début de colonne

        float leftX  = margin;
        float rightX = midX + colGap;

        float leftMaxWidth  = midX - leftX - colGap;            // un peu d'espace au centre
        float rightMaxWidth = (margin + contentWidth) - rightX; // jusqu'au bord droit

        // Titres colonnes
        float y = yStart;
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 11);
        cs.newLineAtOffset(leftX, y);
        cs.showText("Positives");
        cs.endText();

        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 11);
        cs.newLineAtOffset(rightX, y);
        cs.showText("Negatives");
        cs.endText();

        y -= 14f;

        // On écrit les deux colonnes en parallèle, ligne par ligne
        int leftSize  = leftStats.size();
        int rightSize = rightStats.size();
        int maxRows = Math.max(leftSize, rightSize);

        // Afin de conserver l'ordre d’insertion, si tu y tiens, tu peux utiliser LinkedHashMap côté appelant.
        // ...
        var leftIter  = leftStats.entrySet().iterator();
        var rightIter = rightStats.entrySet().iterator();

        float yLeft = y;
        float yRight = y;

        for (int i = 0; i < maxRows; i++) {
            if (leftIter.hasNext()) {
                var e = leftIter.next();
                String k = e.getKey();
                Double v = e.getValue();
                Color c = statColorForKey(/* game */ currentGameRef, /* isTeam1 */ currentIsTeam1Ref, k);
                yLeft = writeKeyValueOneLineColored(cs, k, nf.format(v), leftX, yLeft, 10, c);
            }
            if (rightIter.hasNext()) {
                var e = rightIter.next();
                String k = e.getKey();
                Double v = e.getValue();
                Color c = statColorForKey(/* game */ currentGameRef, /* isTeam1 */ currentIsTeam1Ref, k);
                yRight = writeKeyValueOneLineColored(cs, k, nf.format(v), rightX, yRight, 10, c);
            }
            if (leftIter.hasNext() || rightIter.hasNext()) {
                yLeft  -= 4f;
                yRight -= 4f;
            }
        }


        // Retourner la plus basse des deux colonnes (pour reprendre plus bas)
        return Math.min(yLeft, yRight);
    }

    /** Écrit "clé : valeur" sur UNE ligne, police non-gras, et retourne y- (font+padding). */
    private static float writeKeyValueOneLineColored(PDPageContentStream cs, String key, String value,
                                                 float x, float y, float fontSize, Color color) throws IOException {
    cs.setNonStrokingColor(color);
    cs.beginText();
    cs.setFont(PDType1Font.HELVETICA, fontSize);
    cs.newLineAtOffset(x, y);
    cs.showText((key == null ? "" : key) + " : " + (value == null ? "—" : value));
    cs.endText();
    cs.setNonStrokingColor(Color.BLACK); // reset
    return y - (fontSize + 2f);
}


    // Récupère la couleur (vert/jaune/rouge) d'une stat `key` selon la moyenne
    // du z-score de l'équipe ET du z-score "against" (adversaire) pour ce match.
    private static Color statColorForKey(Game game, boolean isTeam1, String key) {
        double z = statZForKey(game, isTeam1, key);
        return colorForScore(z);
    }

    // Calcule le z-score ∈ [-1, 1] pour une stat (clé) comme la moyenne
    // des deux z-scores disponibles : "for team" et "against opponent".
    private static double statZForKey(Game game, boolean isTeam1, String key) {
        // Sélectionne les bonnes maps selon le côté
        // NB: adapte les getters aux noms exacts de tes accesseurs si besoin
        var teamMap   = isTeam1 ? game.getAllzScoresPerGameForTeam1()
                                : game.getAllzScoresPerGameForTeam2();
        var againstMap= isTeam1 ? game.getAllzScoresPerGameAgainstTeam2()
                                : game.getAllzScoresPerGameAgainstTeam1();

        double v1 = (teamMap   != null && teamMap.containsKey(key))    ? teamMap.get(key)    : Double.NaN;
        double v2 = (againstMap!= null && againstMap.containsKey(key)) ? againstMap.get(key) : Double.NaN;

        // moyenne des valeurs non-NaN
        double z;
        if (Double.isNaN(v1) && Double.isNaN(v2)) {
            z = 0.0; // défaut si rien
        } else if (Double.isNaN(v1)) {
            z = clampMinus1To1(v2);
        } else if (Double.isNaN(v2)) {
            z = clampMinus1To1(v1);
        } else {
            z = clampMinus1To1((v1 + v2) / 2.0);
        }
        return z;
    }

    private static double clampMinus1To1(double x) {
        if (x < -1.0) return -1.0;
        if (x >  1.0) return  1.0;
        return x;
    }


}