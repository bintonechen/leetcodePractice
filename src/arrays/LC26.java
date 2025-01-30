/**
 * Date: 2024/12/22 14:33
 * 26. Remove Duplicates from Sorted Array
 */

package arrays;

public class LC26 {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 1){
            return nums.length;
        }

        int slow = 1; // point to the position where the next unique element will be placed
        int fast = 1; // Iterate through the array to find unique elements

        while (fast <= nums.length-1){
            if(nums[fast]!= nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }
}
