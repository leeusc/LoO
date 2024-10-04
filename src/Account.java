public class Account {

    private String account_number;
    private String name;
    private String address;
    double balance;

    public Account(String account_number, String name, String address, double balance) {
        this.account_number = account_number;
        this.name = name;
        this.address = address;
        this.balance = balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account" +  balance+ "= balance";
    }
}
