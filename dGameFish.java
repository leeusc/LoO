import java.util.Random;
import java.util.Scanner;

public class dGameFish {

    static int level = 1;
    public static void main( String[] args ) {

        final String[] fishing_rods = {"Super", "Xtreame", "Long"};
        final int[] F_VALUE = {5000, 3000, 500};

        final String[] baits = {"Shrimp", "Small fish", "Worm"};
        final int[] B_VALUE = {2500, 1250, 100};

        final String[] rods = {"Senior", "Junior"};
        final  int[] R_VALUE  = {200, 100};

        final String[] fish = {"Nila", "Shark", "Dolphin"};
        final int[] fish_VALUE = {1000, 2000, 2500};
        int next = new Random ().nextInt (fish.length);


        Scanner sc = new Scanner (System.in);


        while (true){

            levelUp ();
            System.out.println ();

        System.out.println ("Choose fishing rod: \"Super\", \"Xtreame\", \"Long\"");
        String fInput = sc.nextLine ();
        sc.nextLine ();

        System.out.println ("Choose bait : \"Shrimp\", \"Small fish\", \"Worm\"");
        String bInput = sc.nextLine ();

        System.out.println ("Choose rod: \"Senior\", \"Junior\"");
        String rInput = sc.nextLine ();

        int fStrength = (getStrength (fishing_rods, F_VALUE, fInput));
        int bStrength = (getStrength (baits, B_VALUE, bInput));
        int rStrength = (getStrength (rods, R_VALUE, rInput));

        // calculate toolStrength
        double toolStrength = (fStrength*1.7) + ( bStrength*1.3) - (rStrength * 0.2);
        double totalToolStrength = (toolStrength) + (level*1000*1.5);

        // get strength until player reached leve; up index
        double storeToolStrength = 0;
        storeToolStrength += toolStrength;
        double storeTotalToolStrength = 0;
        storeTotalToolStrength += totalToolStrength;


        // get the fish
        String h = String.valueOf (fish[next]);
        int fishPower =  (getFishRandom (fish, fish_VALUE, h));
        double totalFish = totalToolStrength/fishPower;

        System.out.println ("Kekuatan alat: " + storeToolStrength);
        System.out.println ("Total Kekuatan alat; " + storeTotalToolStrength);
        System.out.println (h);
        System.out.println ("Ikan yang didapat: " + (int)totalFish);


        System.out.println ("Do you want to Play Again? (true) (false)");
        boolean playAgain = sc.nextBoolean ();


        int getFish = 0;
        getFish+= (int) totalFish;
            if(!playAgain) {
                level = 0;
                System.out.println ("Get fish: " + getFish); // totalFish
                break;
            }
            if (level == 10){
                level = 0;
                System.out.println ("Get fish: " + getFish); // totalFish
                break;
            }
            level++;
        }
    }

    private static int getStrength( String[] type, int[] power, String name ){

        for ( int i = 0; i < type.length; i++ ){
            if (type[i].equals(name)){
                return power[i];
            }
        }
        return -1;
    }

    static int getFishRandom(String[] type, int[] power, String random){

        for ( int i = 0 ; i < type.length; i++ ){
            if (type[i].equals (random)){
                System.out.println (random);
                return power[i];
            }
        }
        return - 1;
    }

    static void levelUp(){

        System.out.println ("Current Level: " + level);

        for ( int i = 0; i <= level; i++ ){
            if (level == i) System.out.print ("🍥");
        }
    }
}