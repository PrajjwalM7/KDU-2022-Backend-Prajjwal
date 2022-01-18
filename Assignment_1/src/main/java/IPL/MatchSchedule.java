package IPL;

import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class MatchSchedule {
    static List<Match> matches;
    static String IPLScheduleFilePath = "src/main/resources/IPL_2021_Schedule.csv";


    public static void buildMatchSchedule(Map<String, Team> teams) {
        int numberOfMatchesInTournament = teams.size() * ( teams.size() - 1 );
        matches = new ArrayList<Match>();

        List<Integer> availableMatchIDs = getRandomizedAvailableMatchID(numberOfMatchesInTournament);
        List<String> listOfTeams = teams.keySet().stream().collect(Collectors.toList());

        buildSchedule(listOfTeams, teams, availableMatchIDs);
        sortMatchesByMatchID();
        saveMatchScheduleToCSVFile();
    }

    private static void saveMatchScheduleToCSVFile() {
        FileWriter fileWriter;
        CSVFormatProcessor processor = new CSVFormatProcessor();
        try {
            fileWriter = new FileWriter(IPLScheduleFilePath);
            for (Match match : matches) {
                fileWriter.write(processor.format(match) + "\n");
            }
            fileWriter.close();
        } catch(Exception e) {
            System.out.println("Could not create file." + e.getMessage());
        }
    }

    private static List<Integer> getRandomizedAvailableMatchID(int numberOfMatchesInTournament) {
        List<Integer> availableMatchIDs = new ArrayList<Integer>();
        for(int number = 1; number <= numberOfMatchesInTournament; number++) {
            availableMatchIDs.add(number);
        }
        Collections.shuffle(availableMatchIDs);
        return availableMatchIDs;
    }

    private static void buildSchedule(List<String> listOfTeams, Map<String, Team> teams, List<Integer> availableMatchIDs) {
        Match match;
        int currentMatchNumberIndex = 0;
        for(int team1IndexInList = 0; team1IndexInList < listOfTeams.size() - 1; team1IndexInList++) {
            for(int team2IndexInList = team1IndexInList + 1; team2IndexInList < listOfTeams.size(); team2IndexInList++) {

                match = new Match(teams.get(listOfTeams.get(team1IndexInList)),
                        teams.get(listOfTeams.get(team2IndexInList)), availableMatchIDs.get(currentMatchNumberIndex),
                        teams.get(listOfTeams.get(team1IndexInList)).getHomeGround());
                matches.add(match);
                currentMatchNumberIndex++;

                match = new Match(teams.get(listOfTeams.get(team2IndexInList)),
                        teams.get(listOfTeams.get(team1IndexInList)), availableMatchIDs.get(currentMatchNumberIndex),
                        teams.get(listOfTeams.get(team2IndexInList)).getHomeGround());
                matches.add(match);
                currentMatchNumberIndex++;
            }
        }
    }

    private static void sortMatchesByMatchID() {
        Collections.sort(matches, new Comparator<Match>() {
            @Override
            public int compare(Match m1, Match m2) {
                return m1.getMatchNumber() - m2.getMatchNumber();
            }
        });
    }

}
