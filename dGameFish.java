import java.util.Random;
import java.util.Scanner;

public class dGameFish {

    static int level = 5;
    public static void main( String[] args ) {

        final String[] fishing_rods = {"Super", "Xtreame", "Long"};
        final int[] F_VALUE = {5000, 3000, 500};

        final String[] baits = {"Shrimp", "Small fish", "Worm"};
        final int[] B_VALUE = {2500, 1250, 100};

        final String[] rods = {"Senior", "Junior"};
        final  int[] R_VALUE  = {200, 100};

        final String[] fish = {"Nila", "Shark", "Dolphin"};
        final int[] fish_VALUE = {1000, 2000, 2500};
        //int next = new Random ().nextInt (fish.length);
//        int fishPower =  (getFishRandom (fish, fish_VALUE, h));
//        double totalFish = totalToolStrength/fishPower;


        Scanner sc = new Scanner (System.in);

        System.out.println ("Set current Level: (1 - 10)");
        int level = sc.nextInt ();
            levelUp (level);

        System.out.println ("\n");

        System.out.println ("Choose fishing rod: \"Super\", \"Xtreame\", \"Long\"");
        String fishingrod_Input = sc.next ();

        System.out.println ("Choose bait : \"Shrimp\", \"Small fish\", \"Worm\"");
        String bait_Input = sc.next ();

        System.out.println ("Choose rod: \"Senior\", \"Junior\"");
        String rod_Input = sc.next ();

        System.out.println ("Choose rod: \"Nila\", \"Shark\", \"Dolphin\"");
        String fishInput = sc.next ();

        int fish_Strength = (getStrength (fishing_rods, F_VALUE, fishingrod_Input));
        int bait_Strength = (getStrength (baits, B_VALUE, bait_Input));
        int rod_Strength = (getStrength (rods, R_VALUE, rod_Input));
        int fishStrength = (getStrength (fish, fish_VALUE, fishInput));
        System.out.println (fishStrength);

        // calculate toolStrength
        double toolStrength = (fish_Strength*1.7) + ( bait_Strength*1.3) - (rod_Strength * 0.2);
        double totalToolStrength = (toolStrength) + (level*1000*1.5);

        double totalFish = totalToolStrength/fishStrength;

        System.out.println ("Kekuatan alat: " + toolStrength);
        System.out.println ("Total Kekuatan alat; " + totalToolStrength);
        //System.out.println (h);
        System.out.println ("Ikan yang didapat: " + (int)totalFish);


//        System.out.println ("Do you want to Play Again? (true) (false)");
//        boolean playAgain = sc.nextBoolean ();


        int getFish = 0;
        getFish+= (int) totalFish;
        System.out.println (getFish);
//            if(!playAgain) {
//                level = 0;
//                System.out.println ("Get fish: " + getFish); // totalFish
//            }
//            if (level == 10){
//                level = 0;
//                System.out.println ("Get fish: " + getFish); // totalFish
//            }
        //    level++;
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

    static void levelUp(int level){

        System.out.println ("Current Level: " + level);

        for ( int i = 0; i < level; i++ ){
            System.out.print ("🍥");
        }
    }
}