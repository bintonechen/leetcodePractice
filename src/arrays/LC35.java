/**
 * Date: 2024/12/17 09:21
 * 35. Search Insert Position
 */

package arrays;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums[0]>target){
            return 0;
        }

        if(nums[nums.length-1]<target){
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]<target){
                left = mid+1;
            } else { // if (nums[mid]>target)
                right = mid-1;
            }
        }
        return left;
    }
}
