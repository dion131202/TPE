package com.simon.app;

import java.io.IOException;
import java.nio.file.Path;
public class main {
    public static void main(String[] args) throws IOException {

        /*
         * PIPELINE
         * 
         * 1. Create League
         * 2. Create Teams and add them to the League
         * 3. Add one game
         * 4. Compute z-scores with mean and stdDev of the previous games (so there is no data leakage).
         * 5. Update mean and stdDev
         * 6. Add next game
         * 7. ...
         */
        
        System.out.println("Creating a new league: RSEQUniversitaireD22025");
        League RSEQUniversitaireD22025 = new League("RSEQUniversitaireD2", 2025);

        System.out.println("Creating a new team: ÉTS");
        Team ETS = new Team("ETS");

        System.out.println("Creating a new team: Concordia");
        Team Concordia = new Team("Concordia");

        System.out.println("Creating a new team: UQAC");
        Team UQAC = new Team("UQAC");

        System.out.println("Creating a new team: UQO");
        Team UQO = new Team("UQO");

        RSEQUniversitaireD22025.addTeam(ETS);
        RSEQUniversitaireD22025.addTeam(Concordia);
        RSEQUniversitaireD22025.addTeam(UQAC);
        RSEQUniversitaireD22025.addTeam(UQO);








        //We do not compute z-scores for the first game of each team, as there is no prior data to compute mean and stdDev.

        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSUQAC251003 = new Game("G001", 
                                                                "2025-10-03", 
                                                                "C:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-UQAC-03-10-25.csv",
                                                                "C:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-ETS-03-10-25.csv",
                                                                ETS,
                                                                UQAC);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSUQAC251003);

        ETS.addGame(RSEQUniversitaireD22025ETSVSUQAC251003);
        UQAC.addGame(RSEQUniversitaireD22025ETSVSUQAC251003);

        RSEQUniversitaireD22025ETSVSUQAC251003.addStatsToTeams();









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSUQAC251004 = new Game("G002", 
                                                                "2025-10-04", 
                                                                "C:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-UQAC-04-10-25.csv",
                                                                "C:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-ETS-04-10-25.csv",
                                                                ETS,
                                                                UQAC);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSUQAC251004);

        ETS.addGame(RSEQUniversitaireD22025ETSVSUQAC251004);
        UQAC.addGame(RSEQUniversitaireD22025ETSVSUQAC251004);

        RSEQUniversitaireD22025ETSVSUQAC251004.addStatsToTeams();










        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025UQOVSConcordia251004 = new Game("G003", 
                                                                "2025-10-04", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQO/RSEQUniversitaireD22025-UQO-VS-Concordia-04-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-UQO-04-10-25.csv",
                                                                UQO,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025UQOVSConcordia251004);

        UQO.addGame(RSEQUniversitaireD22025UQOVSConcordia251004);
        Concordia.addGame(RSEQUniversitaireD22025UQOVSConcordia251004);

        RSEQUniversitaireD22025UQOVSConcordia251004.addStatsToTeams();
    









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSUQO251011 = new Game("G004", 
                                                                "2025-10-11", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-UQO-11-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQO/RSEQUniversitaireD22025-UQO-VS-ETS-11-10-25.csv",
                                                                ETS,
                                                                UQO);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSUQO251011);

        ETS.addGame(RSEQUniversitaireD22025ETSVSUQO251011);
        UQO.addGame(RSEQUniversitaireD22025ETSVSUQO251011);

        RSEQUniversitaireD22025ETSVSUQO251011.setTeamsZScores();

        RSEQUniversitaireD22025ETSVSUQO251011.addStatsToTeams();

        Path pdf1 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251011-ETS",   
                "G004",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf1.toAbsolutePath());

        
        Path pdf2 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251011-UQO",
                "G004",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf2.toAbsolutePath());










        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025UQACVSConcordia251012 = new Game("G005", 
                                                                "2025-10-12", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-Concordia-12-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-UQAC-12-10-25.csv",
                                                                UQAC,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025UQACVSConcordia251012);

        UQAC.addGame(RSEQUniversitaireD22025UQACVSConcordia251012);
        Concordia.addGame(RSEQUniversitaireD22025UQACVSConcordia251012);

        RSEQUniversitaireD22025UQACVSConcordia251012.setTeamsZScores();

        RSEQUniversitaireD22025UQACVSConcordia251012.addStatsToTeams();

        Path pdf3 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251012-UQAC",   
                "G005",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf3.toAbsolutePath());

        
        Path pdf4 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251012-Concordia",
                "G005",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf4.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025UQOVSConcordia251017 = new Game("G006", 
                                                                "2025-10-17", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQO/RSEQUniversitaireD22025-UQO-VS-Concordia-17-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-UQO-17-10-25.csv",
                                                                UQO,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025UQOVSConcordia251017);
        UQO.addGame(RSEQUniversitaireD22025UQOVSConcordia251017);
        Concordia.addGame(RSEQUniversitaireD22025UQOVSConcordia251017);

        RSEQUniversitaireD22025UQOVSConcordia251017.setTeamsZScores();

        RSEQUniversitaireD22025UQOVSConcordia251017.addStatsToTeams();

        Path pdf5 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251017-UQO",   
                "G006",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf5.toAbsolutePath());

        
        Path pdf6 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251017-Concordia",
                "G006",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf6.toAbsolutePath());










        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSConcordia251018 = new Game("G007", 
                                                                "2025-10-18", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-Concordia-18-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-ETS-18-10-25.csv",
                                                                ETS,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSConcordia251018);

        ETS.addGame(RSEQUniversitaireD22025ETSVSConcordia251018);
        Concordia.addGame(RSEQUniversitaireD22025ETSVSConcordia251018);

        RSEQUniversitaireD22025ETSVSConcordia251018.setTeamsZScores();

        RSEQUniversitaireD22025ETSVSConcordia251018.addStatsToTeams();

        Path pdf7 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251018-ETS",   
                "G007",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf7.toAbsolutePath());

        
        Path pdf8 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251018-Concordia",
                "G007",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf8.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSConcordia251025 = new Game("G008", 
                                                                "2025-10-25", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-Concordia-25-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-ETS-25-10-25.csv",
                                                                ETS,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSConcordia251025);

        ETS.addGame(RSEQUniversitaireD22025ETSVSConcordia251025);
        Concordia.addGame(RSEQUniversitaireD22025ETSVSConcordia251025);

        RSEQUniversitaireD22025ETSVSConcordia251025.setTeamsZScores();

        RSEQUniversitaireD22025ETSVSConcordia251025.addStatsToTeams();

        Path pdf9 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251025-ETS",   
                "G008",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf9.toAbsolutePath());

        
        Path pdf10 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251025-Concordia",
                "G008",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf10.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025UQACVSUQO251025 = new Game("G009", 
                                                                "2025-10-25", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-UQO-25-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQO/RSEQUniversitaireD22025-UQO-VS-UQAC-25-10-25.csv",
                                                                UQAC,
                                                                UQO);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025UQACVSUQO251025);

        UQAC.addGame(RSEQUniversitaireD22025UQACVSUQO251025);
        UQO.addGame(RSEQUniversitaireD22025UQACVSUQO251025);

        RSEQUniversitaireD22025UQACVSUQO251025.setTeamsZScores();

        RSEQUniversitaireD22025UQACVSUQO251025.addStatsToTeams();

        Path pdf11 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251025-UQAC",   
                "G009",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf11.toAbsolutePath());

        
        Path pdf12 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251025-UQO",
                "G009",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf12.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025UQACVSUQO251026 = new Game("G010", 
                                                                "2025-10-26", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-UQO-26-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQO/RSEQUniversitaireD22025-UQO-VS-UQAC-26-10-25.csv",
                                                                UQAC,
                                                                UQO);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025UQACVSUQO251026);

        UQAC.addGame(RSEQUniversitaireD22025UQACVSUQO251026);
        UQO.addGame(RSEQUniversitaireD22025UQACVSUQO251026);

        RSEQUniversitaireD22025UQACVSUQO251026.setTeamsZScores();

        RSEQUniversitaireD22025UQACVSUQO251026.addStatsToTeams();

        Path pdf13 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251026-UQAC",   
                "G010",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf13.toAbsolutePath());

        
        Path pdf14 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251026-UQO",
                "G010",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf14.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSConcordia251031 = new Game("G011", 
                                                                "2025-10-31", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-Concordia-31-10-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-ETS-31-10-25.csv",
                                                                ETS,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSConcordia251031);

        ETS.addGame(RSEQUniversitaireD22025ETSVSConcordia251031);
        Concordia.addGame(RSEQUniversitaireD22025ETSVSConcordia251031);

        RSEQUniversitaireD22025ETSVSConcordia251031.setTeamsZScores();

        RSEQUniversitaireD22025ETSVSConcordia251031.addStatsToTeams();

        Path pdf15 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251031-ETS",   
                "G011",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf15.toAbsolutePath());

        
        Path pdf16 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251031-Concordia",
                "G011",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf16.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025UQACVSUQO251101 = new Game("G012", 
                                                                "2025-11-01", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-UQO-01-11-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQO/RSEQUniversitaireD22025-UQO-VS-UQAC-01-11-25.csv",
                                                                UQAC,
                                                                UQO);
        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025UQACVSUQO251101);

        UQAC.addGame(RSEQUniversitaireD22025UQACVSUQO251101);
        UQO.addGame(RSEQUniversitaireD22025UQACVSUQO251101);

        RSEQUniversitaireD22025UQACVSUQO251101.setTeamsZScores();

        RSEQUniversitaireD22025UQACVSUQO251101.addStatsToTeams();

        Path pdf17 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251101-UQAC",   
                "G012",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf17.toAbsolutePath());

        
        Path pdf18 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251101-UQO",
                "G012",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf18.toAbsolutePath());









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSUQAC251102 = new Game("G013", 
                                                                "2025-11-02", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-UQAC-02-11-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/UQAC/RSEQUniversitaireD22025-UQAC-VS-ETS-02-11-25.csv",
                                                                ETS,
                                                                UQAC);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSUQAC251102);

        ETS.addGame(RSEQUniversitaireD22025ETSVSUQAC251102);
        UQAC.addGame(RSEQUniversitaireD22025ETSVSUQAC251102);

        RSEQUniversitaireD22025ETSVSUQAC251102.setTeamsZScores();

        RSEQUniversitaireD22025ETSVSUQAC251102.addStatsToTeams();

        Path pdf19 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251102-ETS",   
                "G013",           
                "team1",         
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf19.toAbsolutePath());

        
        Path pdf20 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251102-UQAC",
                "G013",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf20.toAbsolutePath());
    









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSConcordia251108 = new Game("G014", 
                                                                "2025-11-08", 
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/ETS/RSEQUniversitaireD22025-ETS-VS-Concordia-08-11-25.csv",
                                                                "c:/Users/dion1/P2-TPE/RSEQUniversitaireD22025/Concordia/RSEQUniversitaireD22025-Concordia-VS-ETS-08-11-25.csv",
                                                                ETS,
                                                                Concordia);

        System.out.println("\n\n\n\n\n\n\n\n\n\nAdding the game to the league and to both teams");
        RSEQUniversitaireD22025.addGame(RSEQUniversitaireD22025ETSVSConcordia251108);

        ETS.addGame(RSEQUniversitaireD22025ETSVSConcordia251108);
        Concordia.addGame(RSEQUniversitaireD22025ETSVSConcordia251108);

        RSEQUniversitaireD22025ETSVSConcordia251108.setTeamsZScores();

        RSEQUniversitaireD22025ETSVSConcordia251108.addStatsToTeams();

        
        Path pdf21 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251108-ETS",  
                "G014",         
                "team1",           
                RSEQUniversitaireD22025 
        );
        System.out.println("PDF 1 écrit ici : " + pdf21.toAbsolutePath());

        Path pdf22 = PdfReportGenerator.generateGameReport(
                "RSEQUniversitaireD22025-20251108-Concordia",
                "G014",
                "team2",
                RSEQUniversitaireD22025
        );
        System.out.println("PDF 2 écrit ici : " + pdf22.toAbsolutePath());
    }
}