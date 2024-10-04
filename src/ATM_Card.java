public class ATM_Card {

    String card_number;
    String pin;
    Account curr_account;

    public ATM_Card(String card_number, String pin, Account curr_account) {
        this.card_number = card_number;
        this.pin = pin;
        this.curr_account = curr_account;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Account getCurr_account() {
        return curr_account;
    }

    public void setCurr_account(Account curr_account) {
        this.curr_account = curr_account;
    }

    @Override
    public String toString() {
        return curr_account + "";
    }
}
