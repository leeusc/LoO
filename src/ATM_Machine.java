import java.util.ArrayList;
import java.util.List;

public class ATM_Machine {

    String kodeATM;
    double cash;
    Active_Enum status = Active_Enum.INACTIVE;
    ATM_Card atmCard;
    List<Transaction> transactions;

    public ATM_Machine(String kodeATM, double cash) {
        this.kodeATM = kodeATM;
        this.cash = cash;
        transactions = new ArrayList<>();
    }

    public void insertCard(ATM_Card atmCard){
        this.atmCard = atmCard;
    }

    public void ejectCard(){
        this.status = Active_Enum.INACTIVE;
        atmCard = null;
    }
    public boolean validatePIN(String pin){
        if (atmCard.getPin().equals(pin)){
            status = Active_Enum.ACTIVE;
            return true;
        }
        return false;
    }

    public double checkBalance(){
        if (status == Active_Enum.ACTIVE){
           return atmCard.getCurr_account().getBalance();
        }

        return 0.d;
    }

    public void withdrawal(double amount){
        if(status == Active_Enum.ACTIVE && cash > amount){
            // withdraw money from account
            double curr_balance = atmCard.getCurr_account().getBalance();
            atmCard.getCurr_account().setBalance(curr_balance - amount);

            // create new transaction
            Withdrawal_Transaction wt =  new Withdrawal_Transaction(amount) ;
            transactions.add(wt);
            //System.out.println(wt);

            // cash inside machine is subtracted
            setCash(getCash()-amount);
        }else
            System.out.println("Sorry for inconveniences, Cash in ATM is currently empty");
    }

    public void transfer(Account account, double amount) {
        if (status == Active_Enum.ACTIVE && account.getBalance() >= amount) {
            // transfer from one account to another account
            double curr_balance = atmCard.getCurr_account().getBalance();
            atmCard.getCurr_account().setBalance(curr_balance - amount);
            account.setBalance(account.getBalance() + amount);

            // create new transaction
            Transfer_Transaction tf = new Transfer_Transaction(amount);
            transactions.add(tf);
            //System.out.println(tf);

            // cash inside machine is subtracted
            setCash(getCash() - amount);
        }else
            System.out.println("Your balance is low than transfer amount");
    }

    public void print_withdrawal_Transaction(){

        for (Transaction wt : transactions){
            if (wt instanceof Withdrawal_Transaction){
                System.out.println(wt);
            }
        }
    }

    public void print_transfer_Transaction(){

        for (Transaction tt: transactions){
            if (tt instanceof Transfer_Transaction){
                System.out.println(tt);
            }
        }
    }







    public String getKodeATM() {
        return kodeATM;
    }

    public void setKodeATM(String kodeATM) {
        this.kodeATM = kodeATM;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Active_Enum getStatus() {
        return status;
    }

    public void setStatus(Active_Enum status) {
        this.status = status;
    }

    public ATM_Card getAtmCard() {
        return atmCard;
    }

    public void setAtmCard(ATM_Card atmCard) {
        this.atmCard = atmCard;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "ATM_Machine{" +
                "atmCard=" + atmCard +
                '}';
    }
}
