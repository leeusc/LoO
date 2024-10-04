public class Transfer_Transaction extends Transaction {

    String destination_number;
    double amount;

    Transfer_Transaction(double amount) {
        this.amount = amount;
    }





















    public String getDestination_number() {
        return destination_number;
    }

    public void setDestination_number(String destination_number) {
        this.destination_number = destination_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tTransfer_Transaction: " +
                "destination_number='" + destination_number +
                ", amount=" + amount;
    }
}
