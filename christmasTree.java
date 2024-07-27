//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class christmasTree {
    public static void main( String[] args ) {

       // ChristmasTree();
        ChristmasTree2 (6, 4); // revision
    }

    private static void ChristmasTree() {

    int layer = 6;
        int n = 1;
        while (n < 5) {
            for ( int i = n ; i <= layer ; i++ ) {
                for ( int space = layer ; space > i ; space-- )
                    System.out.print (" ");
                for ( int j = 1 ; j <= (2 * i - 1) ; j++ ) {
                    System.out.print ("*");
                }
                System.out.println ();
            }
            n++;
        }
    }

    private static void ChristmasTree2(int height, int level) {

        int n = 1;
        while (n <= level) {
            for ( int i = n ; i <= height ; i++ ) {
                for ( int space = height ; space > i ; space-- )
                    System.out.print (" ");
                for ( int j = 1 ; j <= (2 * i - 1) ; j++ ) {
                    System.out.print ("*");
                }
                System.out.println ();
            }
            n++;
        }
    }
}