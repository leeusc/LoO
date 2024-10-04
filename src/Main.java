import java.util.ArrayList;
import java.util.List;

public class Main {

    public Main(){

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("100", "Clay", "HighRock street", 800000));
        accounts.add(new Account("101", "Dolly", "Sunny street", 10000));

        ATM_Card atmCard_Clay = new ATM_Card("ID092928", "050403", accounts.getFirst());

        ATM_Machine atmMachine = new ATM_Machine("123", 1500000);
        atmMachine.setAtmCard(atmCard_Clay);

        System.out.println("Selamat datang ke ATM ITHB!\n" + "Please insert your card\n----------------------------\n");
        atmMachine.insertCard(atmCard_Clay);

        System.out.println("Check ATM PIN");
        boolean isValid = atmMachine.validatePIN("050403");
        if (!isValid){
            System.out.println("Pin is wrong, please check again");
            return;
        }
        System.out.println("You were successful!\n-----------------------------\n");

        System.out.println("Checking");
        if (atmMachine.checkBalance() == accounts.getFirst().getBalance()){
            System.out.println("Both hold the same object");
        }
        System.out.println("\n---------------------------------------\n");

        System.out.println("Before withdrawal: " + atmMachine.checkBalance() + " owned by " + accounts.getFirst().getName());
        atmMachine.withdrawal(50000);
        System.out.println("After withdrawal: " + atmMachine.checkBalance() + " owned by " + accounts.getFirst().getName());
        atmMachine.withdrawal(3000);
        System.out.println("\n---------------------------------------\n");


        System.out.printf("Amount before transfer: %s(%s) ------> %s(%s)%n", atmMachine.checkBalance(), accounts.getFirst().getName(), accounts.get(1).getBalance(), accounts.get(1).getName());
        atmMachine.transfer(accounts.get(1), 1000);
        System.out.printf("Amount after transfer: %s(%s) ------> %s(%s)%n", atmMachine.checkBalance(), accounts.getFirst().getName(), accounts.get(1).getBalance(), accounts.get(1).getName());
        System.out.println("\n---------------------------------------\n");
        atmMachine.transfer(accounts.get(1), 100);

        System.out.println("Thank you for completing transaction!. Please take your card");
        atmMachine.ejectCard();
        System.out.println("\n---------------------------------------\n");

        System.out.println("\n---------------------------------------\n");
        System.out.println(atmMachine.checkBalance());
//        System.out.println(atmMachine.getAtmCard().getCurr_account()); // would return throw an exception
        System.out.println("\n---------------------------------------\n");

        System.out.println("\n---------------------------------------\n");
        System.out.println("Print all Withdrawal Transactions: ");
        atmMachine.print_withdrawal_Transaction();
        System.out.println("\n---------------------------------------\n");

        System.out.println("\n---------------------------------------\n");
        System.out.println("Print all Transfer Transactions: ");
        atmMachine.print_transfer_Transaction();
        System.out.println("\n---------------------------------------\n");

        System.out.println("\n---------------------------------------\n");
        ATM_Machine atmMachine2 = new ATM_Machine("123", 9000);
        System.out.println("Print All Transactions in Machine 2");
        atmMachine2.print_transfer_Transaction();
        System.out.println("\n---------------------------------------\n");
    }

    public static void main(String[] args) {
        new Main();
    }
}

