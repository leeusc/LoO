import java.util.Scanner;

public class eMusicSchool {

    public static void main( String[] args ) {

        Scanner sc = new Scanner (System.in);

        int candidate = 1;

        int rcm_Aural = 0;
        int rcm_Sight = 0;
        int tcl_Aural = 0;
        int tcl_Sight = 0;
        String x = "";
        while (true){

            System.out.println ("""
            Have you joined national or international competition" +
              "a. yes, i have" +\s
              "b. yes, but other competition" +\s
              "c. no, i never did"
           \s""");

            String have = sc.nextLine ();
            sc.nextLine ();

            switch ( have ){
                case "a" :
                    System.out.println ("Have participated national and international");
                     x =  ("You passed the selection");
                    System.out.println (x);
                    return;
                case "b", "c":
                    System.out.println ("You have to give test result from RCM and TCL\n");

                    // RCM
                    System.out.println ("(RCM) Enter Aural score: ");
                    rcm_Aural = sc.nextInt ();
                    System.out.println ("(RCM) Enter RCM score: ");
                    rcm_Sight = sc.nextInt ();

                    // TCL
                    System.out.println ("(TCL) Enter Aural score: ");
                    tcl_Aural = sc.nextInt ();
                    System.out.println ("(TCL) Enter RCM score: ");
                    tcl_Sight = sc.nextInt ();

                    if ((rcm_Aural < 12 && rcm_Sight < 14) || ( tcl_Aural < 6 && tcl_Sight < 9)){
                        x =  ("You failed, try again next year!");
                    }

                    else if (rcm_Aural >= 12 && rcm_Aural <= 16 && rcm_Sight >= 14 && rcm_Sight <= 18){
                        if ((tcl_Aural >= 6 && tcl_Aural <= 8 && tcl_Sight >= 9 && tcl_Sight <= 11) ||
                                (tcl_Aural >= 9 && tcl_Aural <= 10 && tcl_Sight >= 12 && tcl_Sight <= 14)){
                            x =  ("You need to get an audition");
                        }
                    }

                    else if (rcm_Aural >= 17 && rcm_Aural <= 18 && rcm_Sight >= 19 && rcm_Sight <= 21){
                        if ((tcl_Aural >= 6 && tcl_Aural <= 8 && tcl_Sight >= 9 && tcl_Sight <= 11) ||
                                (tcl_Aural >= 9 && tcl_Aural <= 10 && tcl_Sight >= 12 && tcl_Sight <= 14)){
                            x = ("You need to get an audition");
                        }
                    }
                    if (rcm_Aural >= 17 && rcm_Aural <= 18 && rcm_Sight >= 19 && rcm_Sight <= 21 &&
                            tcl_Aural >= 9 && tcl_Aural <= 10 && tcl_Sight >= 12 && tcl_Sight <= 14){
                        x = ("You passed the selection");
                    }
                default: break;
            }
            System.out.println ("Candidate no: " + candidate);
            if (have.equals ("a")){
                System.out.println ("Have participated national and international");
            } else if (have.equals ("b")){
                System.out.println ("Have participated in another competition");
            } else if (have.equals ("c")){
                System.out.println ("Never enter in any competition");
            }
            System.out.println ("RCM_Aural: "+ rcm_Aural + " RCM_Sight: " + rcm_Sight);
            System.out.println ("Tcl_Aural: "+ tcl_Aural + " TCL_Sight: " + tcl_Sight);
            System.out.println (x);
            candidate++;

            System.out.println ();
            System.out.println ("next candidate");
        }

    }
}
