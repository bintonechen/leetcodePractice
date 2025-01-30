/**
 * Date: 2024/12/17 07:20
 * 704. Binary Search
 */

package arrays;

public class LC704 {

    // find the exact value approach - assumes no duplicate target
    public int search(int[] nums, int target) {

        // edge case: empty array
        if (nums == null || nums.length == 0)
            return -1;

        // check if the target is out of the range of the array
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;

        int left = 0;
        int right = nums.length -1;

        // binary search loop
        while(left<=right){
            int mid = left + (right-left)/2;

            if (nums[mid] == target ){ // target found
                return mid;
            } else if (nums[mid]>target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // target not found
    }

    // find upper bound approach - with duplicate targets
    public int searchUpperBound(int[] nums, int target) {

        // edge case: empty array
        if (nums == null || nums.length == 0)
            return -1;

        // check if the target is out of the range of the array
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;

        int left = 0;
        int right = nums.length -1;

        // binary search loop
        while (left <=right){
            int mid = left + (right - left)/2;

            if(nums[mid] <= target){
                left = mid + 1;
            } else { //  nums[mid] > target
                right = mid -1;
            }
        }

        // option 1: to use left as the pointer
        if (left-1>=0 && nums[left - 1]== target) {
            return left -1; // rightmost occurrence of the target
        } else {
            return -1; // target not found
        }

        // option 2: to use right as the pointer
//        if (right >= 0 && nums[right] == target) {
//            return right; // Return the rightmost index of the target
//        } else {
//            return -1; // Target not found
//        }

    }


    // find lower bound approach - with duplicate targets
    public int searchLowerBound(int[] nums, int target) {

        // edge case: empty array
        if (nums == null || nums.length == 0)
            return -1;

        // check if the target is out of the range of the array
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;

        int left = 0;
        int right = nums.length -1;

        // binary search loop
        while(left <= right){
            int mid = left + (right - left)/2;

            if (nums[mid] >= target){
                right = mid -1;
            } else { // (nums[mid]<target)
                left = mid + 1;
            }
        }

        // option 1: to use right as the pointer
        if (right + 1 <=nums.length-1 && nums[right + 1] == target){
            return right + 1; // leftmost occurrence of the target
        } else {
            return -1;
        }

        // option 2: to use left as the pointer:
//        if (left<= nums.length-1 && nums[left]==target){
//            return left;
//        } else {
//            return -1;
//        }

    }

}

