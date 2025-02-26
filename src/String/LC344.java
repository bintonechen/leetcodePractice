/**
 * Date: 2025/1/31 13:54
 */

package String;

public class LC344 {
    class Solution {
        public void reverseString(char[] s) {

            int left = 0;
            int right = s.length-1;

            while(left<right){
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }

        }
    }
}
