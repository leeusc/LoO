import java.util.Scanner;

public class eMusicSchool2 {

    static int rcm_Aural;
    static int rcm_Sight;
    static int tcl_Aural;
    static int tcl_Sight;

    static Scanner input = new Scanner (System.in);
    static String x = "";

    public static void main( String[] args ) {


        System.out.println ("""
            Have you joined national or international competition" +
              "a. yes, i have" + \s
              "b. yes, but other competition" +\s
              "c. no, i never did" + \s
           "---------------------------------------------------------------------------"
           \s""");

        String choice = input.next ().toLowerCase ();

        switch ( choice ){
            case "a" :
                A();
                return;
            case "b", "c":
                System.out.println ("You have to give test result from RCM and TCL\n");
                System.out.println ("Choose 1. RCM, 2. TCL");
                String option = input.next ().toLowerCase ();

                switch ( option ){
                    case "1": RCM (); break;
                    case "2": TCL (); break;
                }
        }
    }

    static void A(){
        System.out.println ("Have participated national and international");
        System.out.println ("You passed the selection");
    }

    static void RCM(){

        System.out.println ("(RCM) Enter Aural score: ");
        rcm_Aural = input.nextInt ();
        System.out.println ("(RCM) Enter Sight score: ");
        rcm_Sight = input.nextInt ();

        if (rcm_Aural < 12 || rcm_Sight < 14){
            x =  ("You failed, try again next year!");
        }
        else if ((rcm_Aural >= 12 && rcm_Aural <= 16) || (rcm_Sight>= 14 && rcm_Sight <= 18 )){
            x = ("You need to get an audition");
        }
        else if ((rcm_Aural >= 17 && rcm_Aural <= 18) || rcm_Sight >= 19 && rcm_Sight <= 21) {
            x = ("You passed the selection");
        }

        System.out.println ("RCM Aural: " + rcm_Aural);
        System.out.println ("RCM Sight: " + rcm_Sight);
        System.out.println (x);

    }

    static void TCL(){

        System.out.println ("(TCL) Enter Aural score: ");
        tcl_Aural = input.nextInt ();
        System.out.println ("(TCL) Enter Sight score: ");
        tcl_Sight = input.nextInt ();

        if (tcl_Aural < 6 || tcl_Sight < 9){
            x =  ("You failed, try again next year!");
        }
        else if ((tcl_Aural >= 6 && tcl_Aural <= 8) || (tcl_Sight>= 9 && tcl_Sight <= 11 )){
            x = ("You need to get an audition");        }
        else if ((tcl_Aural >= 9 && tcl_Aural <= 10) || tcl_Sight >= 12 && tcl_Sight <= 14) {
            x = ("You passed the selection");
        }

        System.out.println ("TCL Aural: " + tcl_Aural);
        System.out.println ("TCl Sight: " + tcl_Sight);
        System.out.println (x);
    }
}
