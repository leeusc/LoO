import java.util.Arrays;

public class gArray {

    public static void main( String[] args ) {

        int[] nums = {4,2,5,4,7,2,4,9,5,9};

        sort (nums);
        System.out.println (Arrays.toString (nums));

        duplicateNumber (nums);
    }

    static void duplicateNumber(int[] nums) {

        sort (nums);

        int left = 0;
        int right = 0;
        int count = 0;

//        for ( int right = 0; right < nums.length; right++ ){
//            if (nums[left] == nums[right]){
//                count++;
//            } if(nums[left] != nums[right]) {
//                System.out.println (nums[left] + " appears " + count + " times");
//                left = right;
//                count = 1;
//            }
//        }

        while (right < nums.length) {
            if (nums[ left ] == nums[ right ]) {
                count++;
            }
            if (nums[ left ] != nums[ right ]) {
                System.out.println (nums[left] + " appears " + count + " times");
                left = right;
                count = 1;
            }
            right++;
        }
        System.out.println (nums[nums.length -1] + " appears " + count + " times");
    }


    static void sort(int[] nums){

        for ( int i = 0; i < nums.length -1; i ++ ){
            for ( int j = 1 + i; j > 0; j--){
                if (nums[j] < nums[j - 1]){
                    swapIndex (nums, j, j-1);
                }else break;
            }
        }

    }

    static void swapIndex(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
