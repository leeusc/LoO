public class Withdrawal_Transaction extends Transaction{

    double amount;

    Withdrawal_Transaction(double amount){
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n\tWithdrawal Transaction: " +
                "amount=" + amount;
    }
}
