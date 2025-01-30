/**
 * Date: 2024/12/21 20:01
 * 27. Remove Element
 */

package arrays;

public class LC27 {
    // my approach
    public int removeElement(int[] nums, int val) {
        int upperbound = nums.length - 1;
        for(int i = 0; i <= upperbound; i++){
            if(nums[i] == val){
                nums[i] = nums[upperbound];
                upperbound--;
                i--;
            }
        }
        return upperbound+1;
    }
}
