package IPL;

public class WicketKeeper extends Player {
    public WicketKeeper(String name, Team team, int numberOfMatches,
                  int runs, double averageScore, double strikeRate,
                  int wickets) {
        super(name, team, numberOfMatches, runs, averageScore, strikeRate, wickets);
    }

    /*
        The function getKeeperScore returns a score ( out of 100 )
        that can be used to compare two keepers. A keeper with a better
        score is considered a better keeper.
    */
    public double getKeeperScore() {
        return 0;
    }
}
