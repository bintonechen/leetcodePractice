/**
 * Date: 2024/12/19 10:05
 * 69. Sqrt(x)
 */

package arrays;

public class LC69 {
    class Solution {
        public int mySqrt(int x) {

            if(x == 0 || x == 1){
                return x;
            }

            int left = 1;
            int right = x;

            while (left<=right){
                int mid = left + (right - left)/2;

                if (mid == x / mid){
                    return mid;
                } else if (mid < x / mid){ // mid * mid < x
                    left = mid + 1;
                } else { // mid * mid > x
                    right = mid -1;
                }
            }
            return right;
        }
    }
}
