package IPL;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String fullForm;
    private String homeGround;
    private List<Bowler> bowlers;
    private List<AllRounder> allRounders;
    private List<Batsman> batsmen;
    private List<WicketKeeper> keepers;

    public Team(String name, String fullForm, String homeGround) {
        this.name = name;
        this.fullForm = fullForm;
        this.homeGround = homeGround;
        this.bowlers = new ArrayList<Bowler>();
        this.batsmen = new ArrayList<Batsman>();
        this.keepers = new ArrayList<WicketKeeper>();
        this.allRounders = new ArrayList<AllRounder>();
    }

    public String getName() {
        return this.name;
    }

    public String getFullForm() {
        return this.fullForm;
    }

    public String getHomeGround() {
        return this.homeGround;
    }

    public List<Bowler> getBowlers() {
        return this.bowlers;
    }

    public List<Batsman> getBatsmen() {
        return this.batsmen;
    }

    public List<WicketKeeper> getKeepers() {
        return this.keepers;
    }

    public List<AllRounder> getAllRounders() {
        return this.allRounders;
    }

    public void addBowler(Bowler bowler) {
        this.bowlers.add(bowler);
    }

    public void addBatsman(Batsman batsman) {
        this.batsmen.add(batsman);
    }

    public void addAllRounder(AllRounder allRounder) {
        this.allRounders.add(allRounder);
    }

    public void addWicketKeeper(WicketKeeper keeper) {
        this.keepers.add(keeper);
    }

    public void removeBowler(Bowler bowler) {
        this.bowlers.remove(bowler);
    }

    public void removeBatsman(Batsman batsman) {
        this.batsmen.remove(batsman);
    }

    public void removeAllRounder(AllRounder allRounder) {
        this.allRounders.remove(allRounder);
    }

    public void removeWicketKeeper(WicketKeeper keeper) {
        this.keepers.remove(keeper);
    }

}
