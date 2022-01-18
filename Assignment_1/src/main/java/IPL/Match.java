package IPL;

@CSVFormat
public class Match implements Comparable<Match> {
    @formatValue private Integer matchNumber;
    @formatValue private Team team1;
    @formatValue private Team team2;
    @formatValue private String venue;

    public Match(Team team1, Team team2, int matchNumber, String venue) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchNumber = matchNumber;
        this.venue = venue;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public int compareTo(Match match) {
        return match.getMatchNumber();
    }

    @Override
    public String toString() {
        return getMatchNumber() + "," + getTeam1().getName() + " ---vs--- " + getTeam2().getName() + " --- " + getVenue();
    }
}
