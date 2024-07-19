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
        double first = 60000000;
        double second = 250000000;
        double third = 500000000;

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        //if (pkpValue < 60000000) phhValue = 0;
        if (pkpValue <= first)  a = first * 0.05;
        else if (pkpValue <= second){
            a = first * 0.05;
            b = (pkpValue - first) * 0.15;
        }
        else if (pkpValue <= third){
            a = first * 0.05;
            b = (second - first) * 0.15;
            c = (pkpValue - second) * 0.25;
        }
        else {
            a = first * 0.05;
            b = (second - first) * 0.15;
            c = (third - second) * 0.25;
            d = (pkpValue - 500000000) * 0.30;
        }

        if (b < 0 || c < 0 || d < 0){
            b = 0; c = 0; d = 0;
        }

        phhValue = a + b + c + d;

        if (NPWP) // input sc is false
             return phhValue += phhValue * 0.20;
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
        npwp = sc.hasNext ();

        storePTKP (status, dependants);
        System.out.printf ("PTKP: %.0f%n", ptkpValue);
        storePKP (grossSalary);
        System.out.printf ("PKP: %.0f%n", pkpValue);
        storePHHValue (npwp);
        System.out.printf ("PHH: %.0f%n", phhValue);
    }
}
