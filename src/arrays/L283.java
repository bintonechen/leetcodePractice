/**
 * Date: 2024/12/23 07:15
 * 283. Move Zeroes
 */

package arrays;

public class L283 {

    // solution 1
    public void moveZeroes(int[] nums) {

        int slow = 0;

        for (int fast = 0; fast<= nums.length-1; fast++){

            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
        }

        while (slow<=nums.length-1){
            nums[slow]=0;
            slow++;
        }
    }

    // solution 2
    public void moveZeroes2(int[] nums) {
        int slow = 0;

        for(int fast = 0; fast<= nums.length - 1; fast++){
            if(nums[fast]!=0){
                swap(nums, slow, fast);
                slow++;
            }
        }

    }
    public void swap(int[] nums, int slow, int fast){
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }

}
