public class bPalindrome {
    public static void main( String[] args ) {

        String word = "radar";
        //System.out.println (StringPalindrome ());
        System.out.println (AnotherPalindrome (word));
    }

    static boolean StringPalindrome() {

        String word = "madHm";

        for ( int i = 0; i < word.length () / 2 ; i++ ) {
            if (word.charAt (i) == word.charAt (word.length () - i - 1)){
                System.out.println (word);
                return true;
            }
        }
        return false;
    }


    static boolean AnotherPalindrome(String word){
        if (word == null || word.isEmpty ())
            return true;

        for ( int i = 0; i < word.length (); i++ ){
            char start = word.charAt (i);
            char end = word.charAt (word.length () - 1 - i); // start index from the back

            if (start != end){ // if the start and end is not the same, the string is not palindrome
                return false;
            }
        }
        return true;
    }
}
