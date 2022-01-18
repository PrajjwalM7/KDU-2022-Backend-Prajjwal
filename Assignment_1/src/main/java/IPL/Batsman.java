package IPL;

public class Batsman extends Player{

    public Batsman(String name, Team team, int numberOfMatches,
                  int runs, double averageScore, double strikeRate,
                  int wickets) {
        super(name, team, numberOfMatches, runs, averageScore, strikeRate, wickets);
    }

    /*
        The function getBatsmanScore returns a score ( out of 100 )
        that can be used to compare two batsmen. A batsman with a better
        score is considered a better batsman.
    */
    public double getBatsmanScore() {
        return 0;
    }
}
