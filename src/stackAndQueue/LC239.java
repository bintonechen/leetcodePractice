/**
 * Date: 2025/3/1 10:11
 * 239. Sliding Window Maximum
 */

package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC239 {

    // Brute Force approach
    // with O(n^2) time complexity
    // might cause Time Limit Exceeded
    class Solution {
        public static int[] maxSlidingWindow(int[] nums, int k) {

            int lastIndex = nums.length-1;
            int[] answer = new int[nums.length-k+1];

            for(int i = 0; i<=nums.length-k; i++){

                int temp = Integer.MIN_VALUE;
                int j = i;
                while(j<i+k){
                    temp = Math.max(temp, nums[j]);
                    j++;
                }
                answer[i] = temp;
            }
            return answer;
        }
    }

    // Monotonic Queue approach
    // with O(n) time complexity
    class Solution1 {
        public static int[] maxSlidingWindow(int[] nums, int k) {

            int n = nums.length;
            int [] answer = new int [n-k+1];
            int answerIndex = 0;

            Deque<Integer> indexQue = new ArrayDeque<>();

            for(int i = 0; i<n; i++){

                // remove elements from the front if they are out of the current window
                while(!indexQue.isEmpty() && indexQue.peek()< i-k+1 ){
                    indexQue.poll();
                }

                // remove elements from the back if they are smaller than the current element
                // since they can never be the maximum for future windows
                while(!indexQue.isEmpty() && nums[indexQue.peekLast()]< nums[i]){
                    indexQue.pollLast();
                }

                // add the current element's index to the deque
                indexQue.offer(i);

                if(i>= k-1){
                    answer[answerIndex] = nums[indexQue.peek()];
                    answerIndex++;
                }
            }
            return answer;
        }

    }

    public static void main(String[] args) {

        // test cases to validate the maxSlidingWindow function
        // Test case 0
        int[] nums0 = {1, 3, 1, 2, 0, 5};
        int k0 = 3;
        int[] result0 = Solution1.maxSlidingWindow(nums0, k0);
        System.out.println("Test case 1: " + Arrays.toString(result0)); // Expected: [3, 3, 2, 5]

        // Test case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = Solution1.maxSlidingWindow(nums1, k1);
        System.out.println("Test case 1: " + Arrays.toString(result1)); // Expected: [3, 3, 5, 5, 6, 7]

        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = Solution1.maxSlidingWindow(nums2, k2);
        System.out.println("Test case 2: " + Arrays.toString(result2)); // Expected: [1]
    }


}
