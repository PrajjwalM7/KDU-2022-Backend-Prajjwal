package IPL;

public class Player {
    private String name;
    private Team playerTeam;
    private int numberOfMatches;
    private int runs;
    private double averageScore;
    private double strikeRate;
    private int wickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return  "Name = " + name +
                ", Team = " + playerTeam.getName() +
                ", Number of Matches = " + numberOfMatches +
                ", Runs = " + runs +
                ", Average Score = " + averageScore +
                ", Strike Rate = " + strikeRate +
                ", Wickets = " + wickets;
    }

    public Player(String name, Team team, int numberOfMatches,
                  int runs, double averageScore, double strikeRate,
                  int wickets) {
        this.name = name;
        this.playerTeam = team;
        this.numberOfMatches = numberOfMatches;
        this.runs = runs;
        this.averageScore = averageScore;
        this.strikeRate = strikeRate;
        this.wickets = wickets;
    }

}
