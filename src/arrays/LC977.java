/**
 * Author: Bintong
 * Date: 2024/12/25 11:13
 * 977. Squares of a Sorted Array
 */

package arrays;


import java.util.Arrays;

public class LC977 {

    // solution 1: square all elements and sort the result
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i<=nums.length-1;i++){
            int squareNum = nums[i]*nums[i];
            nums[i] = squareNum;
        }

        Arrays.sort(nums);
        return nums;
    }

    // solution 2: two-pointer approach with negative/positive elements split
    public int[] sortedSquares2(int[] nums) {

        int lastIndex = nums.length-1;
        int lastNeg = -1;

        for (int i = 0; i<=lastIndex; i++){
            if (nums[i]<0){
                lastNeg = i;
            } else {
                break;
            }
        }

        int [] newArray = new int [nums.length];

        int index = 0;
        int i = lastNeg;
        int j = lastNeg+ 1;

        while (i>=0 || j<=lastIndex){

            if(i<0){ // when only positive elements left in nums array
                newArray[index] = nums[j]*nums[j];
                j++;
            } else if (j>lastIndex){ // when only negative elements left in nums array
                newArray[index] = nums[i]*nums[i];
                i--;
            } else if (nums[i]*nums[i]<=nums[j]*nums[j]){
                newArray[index] = nums[i]*nums[i];
                i--;
            } else {
                newArray[index] = nums[j]*nums[j];
                j++;
            }
             index++;
        }
        return newArray;
    }

    // solution 3: two-pointer approach (optimized)
    public int[] sortedSquares3(int[] nums) {

        int i = 0;
        int j = nums.length-1;
        int [] newArray = new int [nums.length];
        int newIndex = j;

        while(i<=j){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                newArray[newIndex] = nums[i]*nums[i];
                newIndex--;
                i++;
            } else {
                newArray[newIndex] = nums[j]*nums[j];
                newIndex--;
                j--;
            }
        }
        return newArray;

    }

}
