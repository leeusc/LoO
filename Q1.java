package quiz1;

import java.util.Random;
import java.util.Scanner;

public class Q1 {

    static Random random = new Random ();

    static String numberCard;
    static String symbolCardName;


    public static void main( String[] args ) {

        Scanner scan = new Scanner (System.in);

        int randomSymbol = random.nextInt (4) + 1;
        int randomNumber = random.nextInt (13) + 1;




        while (true) {

            System.out.println ("# Input SymbolCard (s,h,d,c)__");
            char inputSymbol = scan.next ().toLowerCase ().charAt (0);

            System.out.println ("# Input Number Card (1-13)__");
            int inputNumber = scan.nextInt ();

            System.out.println ();

            if (inputSymbol == symbolCollection (inputSymbol,randomSymbol) && inputNumber == numberCollection (randomNumber)) {
                System.out.println ("Congratulations, your guess is correct: ");
                System.out.print (numberCard + " - " + symbolCardName);
                break;
            }


            if (inputSymbol != symbolCollection (inputSymbol,randomSymbol) ){
                System.out.println ("Symbol is not correct, choose another symbol");
            } else {
                System.out.println ("Symbol is correct, " + symbolCardName);
            }

            System.out.println ();

            if (inputNumber < numberCollection (randomNumber)){
                System.out.println ("Almost correct! smaller");
            } else {
                System.out.println ("Almost correct! greater");
            }



            System.out.println ("\n" + " Correct Answer: " + numberCard + " - " + symbolCardName + "\n");


        }
    }

    static char symbolCollection(char c, int randomSymbol){

        char ch = Character.toLowerCase (c);
        switch ( randomSymbol ){
            case 1: ch = 's'; symbolCardName = "Spade"; break;
            case 2: ch = 'h'; symbolCardName = "Heart"; break;
            case 3: ch = 'd'; symbolCardName = "Diamond";break;
            case 4: ch = 'c'; symbolCardName = "Club" ;break;
        }
        return ch;
    }

    static int numberCollection(int cardNumber){

        switch ( cardNumber ){
            case 1: numberCard = "As"; break;
            case 2: numberCard = "2"; break;
            case 3: numberCard = "3"; break;
            case 4: numberCard = "4"; break;
            case 5: numberCard = "5"; break;
            case 6: numberCard = "6"; break;
            case 7: numberCard = "7"; break;
            case 8: numberCard = "8"; break;
            case 9: numberCard = "9"; break;
            case 10: numberCard = "10"; break;
            case 11: numberCard = "Jack"; break;
            case 12: numberCard = "Queen"; break;
            case 13: numberCard = "King"; break;
        }

        return cardNumber;
    }
}
