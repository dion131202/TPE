package com.simon.app;
import java.io.IOException;

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









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSUQAC251102 = new Game("G0013", 
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









        System.out.println("\n\n\n\n\n\n\n\n\n\nCreating a new game");
        Game RSEQUniversitaireD22025ETSVSConcordia251108 = new Game("G012", 
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
    }
}