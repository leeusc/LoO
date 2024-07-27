import java.util.Scanner;

public class fPilkada {

    static Scanner sc = new Scanner (System.in);

    static int candidate1;
    static int candidate2;
    static int candidate3;

    public static void main( String[] args ) {

        System.out.println ("""
                1. Karren
                2. Gerry
                3. Tommy
                """);

        System.out.println ("Enter number of voters");
        int voters = sc.nextInt ();
        int[] arr = new int[voters];

        Vote (arr);

        System.out.println ();
        System.out.println ("Karren " + candidate1);
        System.out.println ("Gerry " +candidate2);
        System.out.println ("Tommy " + candidate3);

        int max = 0;
        if (candidate1 > candidate2){
            max = candidate1;
            System.out.println ("The New President of the Club is Karren with total score of " + max);
        }
        if (candidate2 > candidate3){
            max = candidate2;
            System.out.println ("The New President of the Club is Gerry with total score of " + max);
        }
        if (candidate3 > candidate1){
            max = candidate3;
            System.out.println ("The New President of the Club is Tommy with total score of " + max);
        }
    }

    static void Vote(int[] arr){

        for ( int i = 0; i < arr.length; i++ ){
            System.out.println ("Choose your candidate: (1/2/3)");
            int choice = sc.nextInt ();
            if (choice == 1) candidate1 ++;
            else if (choice == 2) candidate2++;
            else if (choice == 3) candidate3++;
        }
    }
}
