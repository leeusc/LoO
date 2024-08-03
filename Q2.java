package quiz1;

public class Q2 {

    public static void main( String[] args ) {

        int n = 5;
        one (n);

    }
    static void one(int n){

        int exp = 1;





        for ( int i = 1; i <= 5; i++ ){
            for ( int space = 5; space >= i; space--){
                System.out.print ("~ ");
            }
                int math = (int)((Math.pow (10,exp) -1)/9);
                System.out.println (math * math);
            exp++;

        }
    }


}
