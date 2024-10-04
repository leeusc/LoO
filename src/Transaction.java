import java.time.LocalDate;

public abstract class Transaction {

    String transaction_id;
    LocalDate date;


















    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "- Transaction ID: " + transaction_id + ", Date: " + date;
    }
}
