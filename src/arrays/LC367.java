/**
 * Date: 2024/12/21 14:13
 * 367. Valid Perfect Square
 */

package arrays;

public class LC367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            long left = 1;
            long right = num;

            while (left <= right){
                long mid = left + (right - left)/2;
                long square = mid*mid;

                if(square == num){
                    return true;
                } else if (square<num){
                    left = mid+ 1;
                } else { // (square>num)
                    right = mid -1;
                }
            }
            return false;
        }
    }
}
