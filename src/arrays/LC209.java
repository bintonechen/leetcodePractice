/**
 * Date: 2024/12/25 17:16
 * 209. Minimum Size Subarray Sum
 * Sliding window: https://leetcode.com/explore/featured/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4502/
 */

package arrays;

public class LC209 {

    // solution 1: brute-force approach to check all possible subarrays
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int answer = Integer.MAX_VALUE; // dummy value

        for(int i = 0; i<= nums.length-1; i++){
            int sum = 0;
            for (int j = i; j<= nums.length-1; j++){
                sum = sum + nums[j];
                if(sum >=target){
                    answer = Math.min(answer, j-i+1);
                    break;
                }
            }
        }
        return answer == Integer.MAX_VALUE? 0:answer;

    }

    // solution 2: sliding window
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        while(right<=nums.length-1){
            sum = sum + nums[right];

            while(sum>=target){
                answer = Math.min(answer, right-left+1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return answer == Integer.MAX_VALUE? 0:answer;

    }

}
