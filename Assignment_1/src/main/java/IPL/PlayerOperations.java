package IPL;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerOperations {
    static List<Bowler> bowlers = new ArrayList<Bowler>();
    static List<Batsman> batsmen = new ArrayList<Batsman>();
    static List<WicketKeeper> keepers = new ArrayList<WicketKeeper>();
    static List<AllRounder> allRounders = new ArrayList<AllRounder>();

    static String filePath = "src/main/resources/IPL_2021_data.csv";


    public static void buildPlayers(Map<String, Team> teams) {
        BufferedReader buf;
        String line;

        try {
            buf = new BufferedReader(new FileReader(new File(filePath)));

            // To ignore the headers in the csv file
            String header = buf.readLine();

            while((line = buf.readLine()) != null) {
                List<String> tokens = CSVParser.parseLine(line);
                addPlayer(tokens, teams.get(tokens.get(1)));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found.");
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void addPlayer(List<String> tokens, Team team) {
        switch(tokens.get(2)) {
            case "BOWLER" :
                addBowler(tokens, team);
                break;
            case "BATSMAN" :
                addBatsman(tokens, team);
                break;
            case "WICKET KEEPER" :
                addKeeper(tokens, team);
                break;
            case "ALL ROUNDER" :
                addAllRounder(tokens, team);
                break;
            default :
                System.out.println("Invalid Player Type ! ");
        }
    }

    private static void addBowler(List<String> tokens, Team team) {
        Bowler bowler = new Bowler(tokens.get(0), team, Integer.parseInt(tokens.get(3)),
                Integer.parseInt(tokens.get(4)), Double.parseDouble(tokens.get(5)),
                Double.parseDouble(tokens.get(6)), Integer.parseInt(tokens.get(7)));
        bowlers.add(bowler);
        team.addBowler(bowler);
    }

    private static void addBatsman(List<String> tokens, Team team) {
        Batsman batsman = new Batsman(tokens.get(0), team, Integer.parseInt(tokens.get(3)),
                Integer.parseInt(tokens.get(4)), Double.parseDouble(tokens.get(5)),
                Double.parseDouble(tokens.get(6)), Integer.parseInt(tokens.get(7)));
        batsmen.add(batsman);
        team.addBatsman(batsman);
    }

    private static void addKeeper(List<String> tokens, Team team) {
        WicketKeeper keeper = new WicketKeeper(tokens.get(0), team, Integer.parseInt(tokens.get(3)),
                Integer.parseInt(tokens.get(4)), Double.parseDouble(tokens.get(5)),
                Double.parseDouble(tokens.get(6)), Integer.parseInt(tokens.get(7)));
        keepers.add(keeper);
        team.addWicketKeeper(keeper);
    }

    private static void addAllRounder(List<String> tokens, Team team) {
        AllRounder allRounder = new AllRounder(tokens.get(0), team, Integer.parseInt(tokens.get(3)),
                Integer.parseInt(tokens.get(4)), Double.parseDouble(tokens.get(5)),
                Double.parseDouble(tokens.get(6)), Integer.parseInt(tokens.get(7)));
        allRounders.add(allRounder);
        team.addAllRounder(allRounder);
    }

    public static void searchPlayer() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of the player : ");
        String playerName = in.readLine();
        if(playerName.equals("") || playerName.equals(" ")) {
            System.out.println("Enter a valid name or part of a name.");
            return;
        }

        List<Bowler> matchingBowlers = bowlers.stream().
                filter(b -> b.getName().toLowerCase().contains(playerName.toLowerCase())).collect(Collectors.toList());
        List<Batsman> matchingBatsmen = batsmen.stream().
                filter(bt -> bt.getName().toLowerCase().contains(playerName.toLowerCase())).collect(Collectors.toList());
        List<WicketKeeper> matchingWicketKeepers = keepers.stream().
                filter(wk -> wk.getName().toLowerCase().contains(playerName.toLowerCase())).collect(Collectors.toList());
        List<AllRounder> matchingAllRounders = allRounders.stream().
                filter(ar -> ar.getName().toLowerCase().contains(playerName.toLowerCase())).collect(Collectors.toList());

        printPlayers(matchingBowlers);
        printPlayers(matchingBatsmen);
        printPlayers(matchingWicketKeepers);
        printPlayers(matchingAllRounders);
    }

    private static void printPlayers(List<? extends Player> players) {
        for(Player p : players) {
            System.out.println(p);
        }
    }

    public static void seasonsTopThree() {
        // For batsmen, the criteria is number of runs scored
        List<Batsman> batsmenSortedByRuns = getBatsmenSortedByRuns();
        printBatsmen(batsmenSortedByRuns);

        // For bowlers, the criteria is number of wickets taken
        List<Bowler> bowlersSortedByWickets = getBowlersSortedByWickets();
        printBowlers(bowlersSortedByWickets);


        // For all-rounders, the criteria is "wickets*10 + runs"
        List<AllRounder> allRoundersSorted = getAllRoundersSorted();
        printAllRounders(allRoundersSorted);
    }

    private static List<Batsman> getBatsmenSortedByRuns() {
        return batsmen.stream().sorted(new Comparator<Batsman>() {
            @Override
            public int compare(Batsman o1, Batsman o2) {
                return o2.getRuns() - o1.getRuns();
            }
        }).collect(Collectors.toList());
    }

    private static List<Bowler> getBowlersSortedByWickets() {
        return bowlers.stream().sorted(new Comparator<Bowler>() {
            @Override
            public int compare(Bowler o1, Bowler o2) {
                return o2.getWickets() - o1.getWickets();
            }
        }).collect(Collectors.toList());
    }

    private static List<AllRounder> getAllRoundersSorted() {
        return allRounders.stream().sorted(new Comparator<AllRounder>() {
            @Override
            public int compare(AllRounder o1, AllRounder o2) {
                return (o2.getWickets() * 10 + o2.getRuns()) - (o1.getWickets() * 10 + o1.getRuns());
            }
        }).collect(Collectors.toList());
    }

    private static void printBatsmen(List<Batsman> batsmenSortedByRuns) {
        System.out.println("Top Batsmen :");
        try {
            System.out.println(batsmenSortedByRuns.get(0).getName() + " ---- scored ---- " +
                    batsmenSortedByRuns.get(0).getRuns() + " runs.");
            System.out.println(batsmenSortedByRuns.get(1).getName() + " ---- scored ---- " +
                    batsmenSortedByRuns.get(1).getRuns() + " runs.");
            System.out.println(batsmenSortedByRuns.get(2).getName() + " ---- scored ---- " +
                    batsmenSortedByRuns.get(2).getRuns() + " runs.");
        } catch (IndexOutOfBoundsException e) {
        }
        System.out.println("----------------------------------------");
    }

    private static void printBowlers(List<Bowler> bowlersSortedByWickets) {
        System.out.println("Top Bowlers :");
        try {
            System.out.println(bowlersSortedByWickets.get(0).getName() + " ---- took ---- " +
                    bowlersSortedByWickets.get(0).getWickets() + " wickets.");
            System.out.println(bowlersSortedByWickets.get(1).getName() + " ---- took ---- " +
                    bowlersSortedByWickets.get(1).getWickets() + " wickets.");
            System.out.println(bowlersSortedByWickets.get(2).getName() + " ---- took ---- " +
                    bowlersSortedByWickets.get(2).getWickets() + " wickets.");
        } catch (IndexOutOfBoundsException e) {
        }
        System.out.println("----------------------------------------");
    }

    private static void printAllRounders(List<AllRounder> allRoundersSorted) {
        System.out.println("Top All-rounders : ");
        try {
            System.out.println(allRoundersSorted.get(0).getName() + " ---- scored ---- " +
                    allRoundersSorted.get(0).getRuns() + " runs and " + " ---- took ---- " +
                    allRoundersSorted.get(0).getWickets() + " wickets.");
            System.out.println(allRoundersSorted.get(1).getName() + " ---- scored ---- " +
                    allRoundersSorted.get(1).getRuns() + " runs and " + " ---- took ---- " +
                    allRoundersSorted.get(1).getWickets() + " wickets.");
            System.out.println(allRoundersSorted.get(2).getName() + " ---- scored ---- " +
                    allRoundersSorted.get(2).getRuns() + " runs and " + " ---- took ---- " +
                    allRoundersSorted.get(2).getWickets() + " wickets.");
        } catch (IndexOutOfBoundsException e) {
        }
        System.out.println("----------------------------------------");
    }

}
