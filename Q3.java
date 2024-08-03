package quiz1;

public class Q3 {

    public static void main( String[] args ) {


        int n = 3;
        int thick = 2;

        frame (n,thick);
    }

    static void frame( int n,int thick ) {

        int x = 0;
        int bound = n -1;
        int num = 1;
        int numbound = 1;
        int starbound = 0;
        int star = 0;
        int l = 0;
        int m = 1;
        int star2 = 0;
        int starbound2 = n -2;
        int num2 = n - 1;
        int nums = 0;
        int numbound2 = n -1;
        int y = n - 2;

        int minusn = 1;


        for ( int i = 0 ; i < ((n*2) - 1) + (thick * 2) ; i++ ) {
            for ( int j = 0 ; j < (((n*2) - 1) + (thick * 2)) ; j++ ) {
                if (i < thick || j < thick || i > (n*2 + (n - thick - 1))) {
                    System.out.print ("= ");
                }
            }
            if (i > n - thick && i < (n + thick -1)) {
                for ( int space = 0 ; space < bound ; space++ ) {
                    System.out.print ("~ ");
                }
                bound--;
                for ( int j = 0 ; j < n + x ; j++ ) {
                    if (num <= numbound) {
                        System.out.print (num + " ");
                    }
                    else if (star < starbound){
                        star++;
                        System.out.print ("* ");
                    }
                    else {
                        System.out.print ("~ ");
                    }
                    num++;
                }
                star = 0;
                starbound++;
                num = 0;
                num++;
                numbound++;
                x++;
            }
            if (i == n + thick -1){
                for ( int j = 0 ; j < n + x ; j++ ){
                    if (j < n){
                        l++;
                        System.out.print (l + " ");
                    } else {
                        l--;
                        System.out.print (l + " ");
                    }
                }
            }

            if (i > n + thick - 1 && i < n * 2 + thick - 1){
                for ( int space = 0; space < m; space++){
                    System.out.print ("~ ");
                }
                m++;

                for ( int j = 0; j < n + y; j++ ){
                    if (star2 < starbound2 ){
                        star2++;
                        System.out.print ("* ");
                    }
                    else if (nums < numbound2){
                        nums++;
                        System.out.print (num2 + " ");
                        num2--;
                    }
                    else {
                        System.out.print ("~ ");
                    }
                }
                num2 = (n-1) - minusn;
                minusn++;
                nums = 0;
                numbound2--;
                star2 = 0;
                starbound2--;
                y--;

            }
            for ( int j = 0 ; j < (n*2) - 1 + (thick * 2) ; j++ ) {
                if (j > n * 2 + (n - thick - 1)&& i > n - thick && i < (n * 2) + thick - 1) {
                    System.out.print ("= ");
                }
            }


            System.out.println ();
        }


    }












    static void demo( int n,int height ) {

        int x = 0;
        int bound = 4;
        int num = 1;
        int numbound = 1;
        int starbound = 0;
        int star = 0;
        int l = 0;
        int m = 1;
        int star2 = 0;
        int starbound2 = 3;
        int num2 = 4;
        int nums = 0;
        int numbound2 = 4;
        int y = 3;

        int minusn = 1;


        for ( int i = 0 ; i < 9 + 6 ; i++ ) {
            for ( int j = 0 ; j < 9 + 6 ; j++ ) {
                if (i < 3 || j < 3 || i > 11) {
                    System.out.print ("= ");
                }
            }
            if (i > 2 && i < 7) {
                for ( int space = 0 ; space < bound ; space++ ) {
                    System.out.print ("~ ");
                }
                bound--;
                for ( int j = 0 ; j < n + x ; j++ ) {
                    if (num <= numbound) {
                        System.out.print (num + " ");
                    }
                    else if (star < starbound){
                        star++;
                        System.out.print ("* ");
                    }
                    else {
                        System.out.print ("~ ");
                    }
                    num++;
                }
                star = 0;
                starbound++;
                num = 0;
                num++;
                numbound++;
                x++;
            }
            if (i == 7){
                for ( int j = 0 ; j < n + x ; j++ ){
                    if (j < 5){
                        l++;
                        System.out.print (l + " ");
                    } else {
                        l--;
                        System.out.print (l + " ");
                    }
                }
            }

            if (i > 7 && i < 12){
                for ( int space = 0; space < m; space++){
                    System.out.print ("~ ");
                }
                m++;

                for ( int j = 0; j < n + y; j++ ){
                    if (star2 < starbound2 ){
                        star2++;
                        System.out.print ("* ");
                    }
                    else if (nums < numbound2){
                        nums++;
                        System.out.print (num2 + " ");
                        num2--;
                    }
                    else {
                        System.out.print ("~ ");
                    }
                }
                num2 = 4 - minusn;
                minusn++;
                nums = 0;
                numbound2--;
                star2 = 0;
                starbound2--;
                y--;

            }
            for ( int j = 0 ; j < 9 + 6 ; j++ ) {
                if (j > 11 && i > 2 && i < 12) {
                    System.out.print ("= ");
                }
            }


            System.out.println ();
        }


    }
}
