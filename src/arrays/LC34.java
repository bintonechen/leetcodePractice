/**
 * Date: 2024/12/21 17:18
 * 34. Find First and Last Position of Element in Sorted Array
 */

package arrays;

public class LC34 {

    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int upperBound = searchUpper(nums, target);
            int lowerBound = searchLower(nums, target);

            return new int[]{lowerBound, upperBound};
        }

        public int searchUpper(int[] nums, int target) {
            // edge case: empty array
            if (nums == null || nums.length == 0)
                return -1;

            // check if the target is out of the range of the array
            if (target < nums[0] || target > nums[nums.length - 1])
                return -1;

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left - 1 >= 0 && nums[left - 1] == target) {
                return left - 1;
            } else {
                return -1;
            }
        }

        public int searchLower(int[] nums, int target) {
            // edge case: empty array
            if (nums == null || nums.length == 0)
                return -1;

            // check if the target is out of the range of the array
            if (target < nums[0] || target > nums[nums.length - 1])
                return -1;

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (right + 1 <= nums.length - 1 && nums[right + 1] == target) {
                return right + 1;
            } else {
                return -1;
            }
        }
    }

    // this solution is with O(n) runtime complexity in the worst case
    class Solution2{
        public int[] searchRange(int[] nums, int target) {
            int firstFound = binarySearch(nums, target);

            if (firstFound == -1){
                return new int[] {-1, -1};
            }

            int lowerBound = firstFound;
            int upperBound = firstFound;

            // search left
            while(lowerBound -1 >=0 && nums[lowerBound-1]==target){
                lowerBound--;
            }

            //search right
            while(upperBound+1 <= nums.length-1 && nums[upperBound+1]==target){
                upperBound++;
            }

            return new int[] {lowerBound, upperBound};

        }

        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else { // num[mid]<target
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
