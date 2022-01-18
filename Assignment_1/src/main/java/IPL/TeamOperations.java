package IPL;

import java.util.*;

public class TeamOperations {

    public static Map<String, Team> createTeams() {
        Map<String, Team> teams = new HashMap<String, Team>();

        Team CSK = new Team("CSK", "Chennai Super Kings", "M. A. Chidambaram Stadium");
        Team PBKS = new Team("PBKS", "Punjab Kings", "Punjab Cricket Association Cricket Stadium");
        Team SRH = new Team("SRH", "Sun Risers Hyderabad", "Rajiv Gandhi International Cricket Stadium Hyderabad");
        Team RCB = new Team("RCB", "Royal Challengers Bangalore", "M Chinnaswamy Stadium");
        Team DC = new Team("DC", "Delhi Capitals", "Arun Jaitley Stadium");
        Team RR = new Team("RR", "Rajasthan Royals", "Sawai Mansingh Stadium");
        Team MI = new Team("MI", "Mumbai Indians", "Wankhede Stadium");
        Team KKR = new Team("KKR", "Kolkata Knight Riders", "Eden Garden");

        teams.put("CSK", CSK);
        teams.put("PBKS", PBKS);
        teams.put("SRH", SRH);
        teams.put("RCB", RCB);
        teams.put("DC", DC);
        teams.put("RR", RR);
        teams.put("MI", MI);
        teams.put("KKR", KKR);

        return teams;
    }


    public static void findTop2TeamsWithHighestPredictedScores(Map<String,Team> teams) {

        Map<String, Integer> predictedScores = predictScoresWithBest11(teams);
        List<Map.Entry<String, Integer> > mapEntries =
                new LinkedList<Map.Entry<String, Integer> >(predictedScores.entrySet());

        // Sort the list
        Collections.sort(mapEntries, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> entry1,
                               Map.Entry<String, Integer> entry2) {
                return (entry2.getValue()).compareTo(entry1.getValue());
            }
        });

        System.out.println("Teams with highest predicted scores : ");
        System.out.println(mapEntries.get(0).getKey() + " --- would score a --- " + mapEntries.get(0).getValue());
        System.out.println(mapEntries.get(1).getKey() + " --- would score a --- " + mapEntries.get(1).getValue());
        System.out.println("--------------------------------------------------");
    }


    /*
     * To find the top 11 batsmen, strike rates are used. This will maximize
     * the team score.
     */
    public static Map<String, Integer> predictScoresWithBest11(Map<String, Team> teams) {
        Map<String, Integer> predictedScores = new HashMap<String, Integer>();
        final int NUMBER_OF_BALLS_IN_MATCH = 120;

        for(Map.Entry<String, Team> entry : teams.entrySet()) {
            List<Player> best11Batsmen = fetchTop11(entry.getValue());

            int teamScore = 0;
            int ballsPlayedByTeam = 0;

            for(Player player : best11Batsmen) {
                if(hasScoredInTheSeason(player)) {
                    int predictedBallsByPlayer = predictBallsPlayedByPlayer(player);
                    int predictedScoreByPlayer = predictRunsByPlayer(player);
                    if((NUMBER_OF_BALLS_IN_MATCH - ballsPlayedByTeam) >= predictedBallsByPlayer) {
                        teamScore += predictedScoreByPlayer;
                        ballsPlayedByTeam += predictedBallsByPlayer;
                    } else {
                        teamScore += (predictedScoreByPlayer * (int)((NUMBER_OF_BALLS_IN_MATCH - ballsPlayedByTeam) / predictedBallsByPlayer));
                        ballsPlayedByTeam = NUMBER_OF_BALLS_IN_MATCH;
                    }
                }
            }

            if(ballsPlayedByTeam < NUMBER_OF_BALLS_IN_MATCH) {
                int ballsRemaining = NUMBER_OF_BALLS_IN_MATCH - ballsPlayedByTeam;
                int predictedBallsForBestBatsman = (int) ( (best11Batsmen.get(0).getAverageScore() * 100) / best11Batsmen.get(0).getStrikeRate() );
                teamScore += best11Batsmen.get(0).getAverageScore() * (int)(ballsRemaining / predictedBallsForBestBatsman);
            }
            predictedScores.put(entry.getKey(), teamScore);
        }
        return predictedScores;
    }

    private static int predictBallsPlayedByPlayer(Player player) {
        return (int) (player.getAverageScore() * 100 / player.getStrikeRate());
    }

    private static int predictRunsByPlayer(Player player) {
        return (int) player.getAverageScore();
    }

    private static boolean hasScoredInTheSeason(Player player) {
        return player.getStrikeRate() > 0 ? true : false;
    }

    private static List<Player> fetchTop11(Team team) {
        List<Player> teamBatsmen = (List<Player>)(List<?>)team.getBatsmen();
        List<Player> teamKeepers = (List<Player>)(List<?>)team.getKeepers();
        List<Player> teamAllRounders = (List<Player>)(List<?>)team.getAllRounders();
        List<Player> teamBowlers = (List<Player>)(List<?>)team.getBowlers();

        teamBatsmen.addAll(teamKeepers);
        teamBatsmen.addAll(teamAllRounders);
        teamBatsmen.addAll(teamBowlers);

        Collections.sort(teamBatsmen, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return (int)(p2.getStrikeRate() - p1.getStrikeRate());
            }
        });

        return teamBatsmen.subList(0, 11);
    }

}
