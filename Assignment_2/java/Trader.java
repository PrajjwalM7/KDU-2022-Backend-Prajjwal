public class Trader {
    private String firstName;
    private String lastName;
    private String phone;
    private String wallet;
    private Portfolio portfolio;

    public Trader(String firstName, String lastName, String phone, String wallet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.wallet = wallet;
        portfolio = new Portfolio();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "First Name = " + firstName + " ---- Last Name = " + lastName + " ---- Phone = " + phone + " ---- Wallet = " + wallet;
    }
}
