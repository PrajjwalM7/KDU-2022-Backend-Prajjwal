package IPL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class IPL {

    static Map<String, Team> teams;

    public static void main(String[] args) throws IOException {
        teams =  TeamOperations.createTeams();
        PlayerOperations.buildPlayers(teams);
        MatchSchedule.buildMatchSchedule(teams);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------Choose (enter the number) one of the following to continue : -----------------");
        System.out.println("1 - Players with atleast 40 wickets");
        System.out.println("2 - Highest Run Scorer and Wicket Taker for a team");
        System.out.println("3 - Search for player profiles");
        System.out.println("4 - Top performers of IPL");
        System.out.println("5 - Predicted scores with the Best Playing 11");
        System.out.println("6 - Emerging Players for each team");
        System.out.println("0 - Exit");

        int play = 1;

        while(play > 0 && play < 7) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Enter your choise from the list [0,1,2,3,4,5,6] - ");
            play = Integer.parseInt(in.readLine());
            switch (play) {
                case 1 :
                    System.out.println("************************** Players With At Least 40 Wickets *******************************");
                    TeamStatistics.atleast40Wickets(teams);
                    break;
                case 2 :
                    System.out.println("************************** Highest Run Scorer And Highest Wicket Taker *******************************");
                    TeamStatistics.highestRunsAndWicketTakersForTeam(teams);
                    break;
                case 3 :
                    System.out.println("************************** Search For Player Profiles *******************************");
                    PlayerOperations.searchPlayer();
                    break;
                case 4 :
                    System.out.println("************************** Top Performers Of IPL *******************************");
                    PlayerOperations.seasonsTopThree();
                    break;
                case 5 :
                    System.out.println("************************** Predicted Scores With The Best Playing 11 *******************************");
                    TeamOperations.findTop2TeamsWithHighestPredictedScores(teams);
                    break;
                case 6 :
                    System.out.println("************************** Emerging Players Of Each Team *******************************");
                    EmergingPlayers.nextGenPlayersForEachTeam(teams);
                    break;
                default :
                    System.out.println("Program Terminated");
            }
        }
    }

}
