package IPL;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmergingPlayers {

    public static void nextGenPlayersForEachTeam(Map<String, Team> teams) {

        /*
            CRITERIA
            -- Played less than or equal to 40 matches and more than 4 matches
            -- Batsman OR Wicket-keeper : Has an average score of atleast 30 with a strike rate of more than 120
            -- Bowler : Has atleast 1 wickets per match on an average
            -- All-rounder : Has an average score of atleast 10 with a strike rate of more than 100 and has taken atleast 0.5 wicket per match on an average
         */

        for(Map.Entry<String, Team> entry : teams.entrySet()) {
            System.out.println("----------------------------------------");
            System.out.println("Team : " + entry.getKey());

            findEmergingBatsmen(entry.getValue());
            findEmergingBowlers(entry.getValue());
            findEmergingAllRounders(entry.getValue());
        }
    }

    private static void findEmergingBatsmen(Team team) {
        List<Player> teamBatsmen = (List<Player>)(List<?>)team.getBatsmen();
        List<Player> teamKeepers = (List<Player>)(List<?>)team.getKeepers();
        teamBatsmen.addAll(teamKeepers);
        teamBatsmen = emergingBatsmen(teamBatsmen);
        System.out.println("Emerging Batsmen : ");
        if (teamBatsmen.size() == 0) {
            System.out.println("None in this category.");
        } else {
            for (Player p : teamBatsmen) {
                System.out.println(p);
            }
        }
    }

    private static void findEmergingBowlers(Team team) {
        List<Player> teamBowlers = (List<Player>)(List<?>)team.getBowlers();
        teamBowlers = emergingBowlers(teamBowlers);
        System.out.println("Emerging Bowler : ");
        if (teamBowlers.size() == 0) {
            System.out.println("None in this category.");
        } else {
            for (Player p : teamBowlers) {
                System.out.println(p);
            }
        }
    }

    private static void findEmergingAllRounders(Team team) {
        List<Player> teamAllRounders = (List<Player>)(List<?>)team.getAllRounders();
        teamAllRounders = emergingAllRounder(teamAllRounders);
        System.out.println("Emerging All-rounders : ");
        if (teamAllRounders.size() == 0) {
            System.out.println("None in this category.");
        } else {
            for (Player p : teamAllRounders) {
                System.out.println(p);
            }
        }
    }

    public static List<Player> emergingBatsmen(List<Player> teamBatsmen) {
        List<Player> emergingBatsmen = teamBatsmen.stream().
                filter(p -> p.getNumberOfMatches() <= 40 && p.getNumberOfMatches() >= 5 && p.getAverageScore() >= 20 && p.getStrikeRate() >= 120).
                collect(Collectors.toList());
        return emergingBatsmen;
    }

    public static List<Player> emergingBowlers(List<Player> teamBowlers) {
        List<Player> emergingBowler = teamBowlers.stream().
                filter(p -> p.getNumberOfMatches() <= 40 && p.getNumberOfMatches() >= 5 && (p.getWickets() / p.getNumberOfMatches()) >= 1).
                collect(Collectors.toList());
        return emergingBowler;
    }

    public static List<Player> emergingAllRounder(List<Player> teamAllRounder) {
        List<Player> emergingAllRounder = teamAllRounder.stream().
                filter(p -> p.getNumberOfMatches() <= 40 && p.getNumberOfMatches() >= 5 && p.getAverageScore() >= 10 && p.getStrikeRate() >= 100 && (p.getWickets() / p.getNumberOfMatches()) >= 0.5).
                collect(Collectors.toList());
        return emergingAllRounder;
    }
}
