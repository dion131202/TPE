package com.simon.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;

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

                    y = scoreRow(cs, page, margin, y, "Offense attack",
                            isTeam1 ? game.offenseAttackEvaluationTeam1 : game.offenseAttackEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Offense control",
                            isTeam1 ? game.offenseControlEvaluationTeam1 : game.offenseControlEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Entries",
                            isTeam1 ? game.entriesEvaluationTeam1 : game.entriesEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Controlled entries",
                            isTeam1 ? game.controlledEntriesEvaluationTeam1 : game.controlledEntriesEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Uncontrolled entries",
                            isTeam1 ? game.uncontrolledEntriesEvaluationTeam1 : game.uncontrolledEntriesEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Offense without puck",
                            isTeam1 ? game.offenseWithoutPuckEvaluationTeam1 : game.offenseWithoutPuckEvaluationTeam2, nf);
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

                    y = scoreRow(cs, page, margin, y, "Defensive zone defense",
                            isTeam1 ? game.defensiveZoneDefenseEvaluationTeam1 : game.defensiveZoneDefenseEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Neutral zone defense",
                            isTeam1 ? game.neutralzoneDefenseEvaluationTeam1 : game.neutralzoneDefenseEvaluationTeam2, nf);

                    y = scoreRow(cs, page, margin, y, "Exits",
                            isTeam1 ? game.exitsEvaluationTeam1 : game.exitsEvaluationTeam2, nf);
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

                    y = scoreRow(cs, page, margin, y, "Global transition",
                            isTeam1 ? game.transitionEvaluationTeam1 : game.transitionEvaluationTeam2, nf);
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

                    y = scoreRow(cs, page, margin, y, "Global physicality",
                            isTeam1 ? game.physicalityEvaluationTeam1 : game.physicalityEvaluationTeam2, nf);
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

                    y = scoreRow(cs, page, margin, y, "Global energy management",
                            isTeam1 ? game.energyManagementEvaluationTeam1 : game.energyManagementEvaluationTeam2, nf);
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
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 20);
        cs.newLineAtOffset(x, y);
        cs.showText(text);
        cs.endText();
        return y - 30f;
    }

    private static float bigSectionHeader(PDPageContentStream cs, String text, float x, float y) throws IOException {
        y -= 6f;
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 18);
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
    }

    private static Color colorForScore(double s) {
        if (s <= -0.25) return new Color(205, 73, 69);      // rouge
        if (s >=  0.25) return new Color(66, 160, 88);      // vert
        return new Color(231, 183, 67);                     // jaune
    }
}
