public class AddVolume extends Transaction {
    private long volume;

    AddVolume(String coin, long volume) {
        super(coin);
        this.volume = volume;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public void run() {
        Coin volumeAddCoin = CoinBuilder.getCoin(super.coin);
        if(volumeAddCoin != null)
            volumeAddCoin.completeVolume(volume);
    }
}
