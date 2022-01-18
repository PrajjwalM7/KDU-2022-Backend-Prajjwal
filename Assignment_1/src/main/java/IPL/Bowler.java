package IPL;

public class Bowler extends Player {

    public Bowler(String name, Team team, int numberOfMatches,
                  int runs, double averageScore, double strikeRate,
                  int wickets) {
        super(name, team, numberOfMatches, runs, averageScore, strikeRate, wickets);
    }

    /*
        The function getBowlerScore returns a score ( out of 100 )
        that can be used to compare two bowlers. A bowler with a better
        score is considered a better bowler.
    */
    public double getBowlerScore() {
        return 0;
    }

}
