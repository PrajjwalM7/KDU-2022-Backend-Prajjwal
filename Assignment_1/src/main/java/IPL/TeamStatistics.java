package IPL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamStatistics {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void atleast40Wickets(Map<String, Team> teams) throws IOException {
        System.out.println("Enter the team name (short form) to get the list of bowlers with atleast 40 wickets : ");
        String teamName = in.readLine();
        teamName = teamName.toUpperCase();
        Team team = teams.get(teamName);
        List<Bowler> atleast40Wickets =  bowlersWithAtleast40Wickets(team);

        System.out.println("Bowlers with atleast 40 wickets in " + teamName + " : ");
        for(Bowler b : atleast40Wickets) {
            System.out.println(b.getName() + " --> " + b.getWickets());
        }
    }

    private static List<Bowler> bowlersWithAtleast40Wickets(Team team) {
        List<Bowler> teamBowlers = team.getBowlers();
        List<Bowler> atleast40Wickets = teamBowlers.stream().filter(b -> b.getWickets() >= 40).collect(Collectors.toList());
        return atleast40Wickets;
    }

    public static void highestRunsAndWicketTakersForTeam(Map<String, Team> teams) throws IOException {
        System.out.println("Enter the team name (short form) : ");
        String teamName = in.readLine();
        teamName = teamName.toUpperCase();
        Team team = teams.get(teamName);

        Player highestRunScorer = getHighestRunScorer(team);
        Player highestWicketTaker = getHighestWicketTaker(team);

        System.out.println("Highest Run Scorer for " + teamName + " : ");
        System.out.println(highestRunScorer);
        System.out.println("Highest Wicket Taker for " + teamName + " : ");
        System.out.println(highestWicketTaker);
    }

    public static Player getHighestRunScorer(Team team) {
        Batsman batsman = team.getBatsmen().stream().max((Batsman b1, Batsman b2) -> b1.getRuns() - b2.getRuns()).get();
        AllRounder allRounder = team.getAllRounders().stream().max((AllRounder a1, AllRounder a2) -> a1.getRuns() - a2.getRuns()).get();
        WicketKeeper keeper = team.getKeepers().stream().max((WicketKeeper w1, WicketKeeper w2) -> w1.getRuns() - w2.getRuns()).get();

        if(batsman.getRuns() >= allRounder.getRuns() && batsman.getRuns() >= keeper.getRuns()) {
            return (Player) batsman;
        } else if(allRounder.getRuns() >= batsman.getRuns() && allRounder.getRuns() >= keeper.getRuns()) {
            return (Player) allRounder;
        } else {
            return (Player) keeper;
        }
    }

    public static Player getHighestWicketTaker(Team team) {
        Bowler bowler = team.getBowlers().stream().max((Bowler b1, Bowler b2) -> b1.getWickets() - b2.getWickets()).get();
        AllRounder allRounder = team.getAllRounders().stream().max((AllRounder a1, AllRounder a2) -> a1.getWickets() - a2.getWickets()).get();
        if(bowler.getWickets() >= allRounder.getWickets()) {
            return (Player) bowler;
        } else {
            return (Player) allRounder;
        }
    }

}
