package IPL;

public class AllRounder extends Player{
    public AllRounder(String name, Team team, int numberOfMatches,
                  int runs, double averageScore, double strikeRate,
                  int wickets) {
        super(name, team, numberOfMatches, runs, averageScore, strikeRate, wickets);
    }

    /*
        The function getAllRounderScore returns a score ( out of 100 )
        that can be used to compare two All-rounders. An all-rounder
        with a better score is considered a better all-rounder.
    */
    public double getAllRounderScore() {
        return 0;
    }
}
