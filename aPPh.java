import java.util.Scanner;

public class aPPh {

    static double grossSalary;
    static boolean status;
    static int dependants;
    static boolean npwp;
    static double ptkpValue;
    static double pkpValue;
    static double phhValue;

    static void storePTKP(boolean status, int haveDependants){
        ptkpValue = PTKP (status, haveDependants);
    }

    static double PTKP(boolean status, int haveDependants){
        double basicPTKP = 54000000;
        double married = 4500000;
        double dependants = 4500000;
        if (haveDependants > 3)
            haveDependants = 3;
        if (status)
            return (basicPTKP + married + haveDependants * dependants);
        else
            return (basicPTKP + haveDependants * dependants);

    }

    static void storePKP(double salaryGross){
        pkpValue = PKP (salaryGross);
    }

    static double PKP(double salaryGross){
        // PKP = AnnualGrossSalary - PTKP

        if (ptkpValue > salaryGross)
            return 0; // if PTKP exceeds AnnualGrossSalary the PKP would be zero
        return salaryGross - ptkpValue;
    }

    static void storePHHValue( boolean NPWP){
        phhValue = PPHValue (npwp);
    }
    static double PPHValue(boolean NPWP){
        /*
         Tax BRACKETS
         1. Up to IDR 60,000,000: 5%
         2. IDR 60,000,001 to 250,000,000: 15%
         3. IDR 250,000,001 to 500,000,000: 25%
         4. Above IDR 500,000,000: 30%
        */
        double first_Bracket = 60000000;
        double second_Bracket = 250000000;
        double third_Bracket = 500000000;

        double total_1_Brckt = 0;
        double total_2_Brckt = 0;
        double total_3_Brckt = 0;
        double total_4_Brckt = 0;

        // base condition
        if (pkpValue == 0){
            return phhValue = 0;
        }

        //if (pkpValue < 60000000) phhValue = 0;
        if (pkpValue <= first_Bracket)  total_1_Brckt = first_Bracket * 0.05;
        else if (pkpValue <= second_Bracket){
            total_1_Brckt = first_Bracket * 0.05;
            total_2_Brckt = (pkpValue - first_Bracket) * 0.15;
        }
        else if (pkpValue <= third_Bracket){
            total_1_Brckt = first_Bracket * 0.05;
            total_2_Brckt = (second_Bracket - first_Bracket) * 0.15;
            total_3_Brckt = (pkpValue - second_Bracket) * 0.25;
        }
        else {
            total_1_Brckt = first_Bracket * 0.05;
            total_2_Brckt = (second_Bracket - first_Bracket) * 0.15;
            total_3_Brckt = (third_Bracket - second_Bracket) * 0.25;
            total_4_Brckt = (pkpValue - 500000000) * 0.30;
        }

        // in case below zero or negative number
        if (total_2_Brckt < 0 || total_3_Brckt < 0 || total_4_Brckt < 0){
            total_2_Brckt = 0; total_3_Brckt = 0; total_4_Brckt = 0;
        }

        phhValue = total_1_Brckt + total_2_Brckt + total_3_Brckt + total_4_Brckt;

        double penalty = 0.20; // for no NPWP

        if (!NPWP) // input sc is false
             return phhValue += phhValue * penalty;
        else return phhValue; // if input is true
    }


    public static void main( String[] args ) {

        Scanner sc = new Scanner (System.in);

        System.out.println ("Annual Gross Salary: ");
        grossSalary = sc.nextDouble ();

        System.out.println ("Marital status: (Married - true) (Not - false)");
        status = sc.nextBoolean ();

        System.out.println ("Dependants: "); // hava child?
        dependants = sc.nextInt ();

        System.out.println ("Has NPWP: (have - true) (not - false)");
        npwp = sc.nextBoolean ();

        storePTKP (status, dependants);
        System.out.printf ("PTKP: %.0f%n", ptkpValue);
        storePKP (grossSalary);
        System.out.printf ("PKP: %.0f%n", pkpValue);
        storePHHValue (npwp);
        System.out.printf ("PHH: %.0f%n", phhValue);
    }
}
