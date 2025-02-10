/**
 * Date: 2025/1/31 14:24
 * 541. Reverse String II
 */

package String;


public class LC541 {

    // my approach
    public String reverseStr(String s, int k) {

        int seen = 0;
        int n = s.length();
        char [] answer = s.toCharArray();

        while(seen<n) {
            if (n - seen < k) {
                // case 1: fewer than k characters left, reverse all of them
                int left = seen;
                int right = n-1;
                while(left<right){
                    answer[left] = s.charAt(right);
                    answer[right] = s.charAt(left);
                    left++;
                    right--;
                }
                seen = n; // break the while loop
            } else if(n-seen>=2*k){
                // case 2: more than 2*k characters remaining
                int left = seen;
                int right = seen+k-1;
                while(left<right){
                    answer[left] = s.charAt(right);
                    answer[right] = s.charAt(left);
                    left++;
                    right--;
                }
                // skip the next k characters unchanged
                seen+=2*k;
            } else {
                // case 3: remaining characters are between k and 2k
                int left = seen;
                int right = seen+k-1;
                while(left<right){
                    answer[left] = s.charAt(right);
                    answer[right] = s.charAt(left);
                    left++;
                    right--;
                }
                // skip the remaining characters unchanged
                seen =n; // break the while loop
            }

        }
        return new String(answer);
    }

    class Solution2{
        public String reverseStr(String s, int k) {

            char [] letters = s.toCharArray();

            for(int i = 0; i<s.length(); i+=2*k){
                int left = i;
                int right = Math.min(s.length()-1, left+k-1);

                while(left<right){
                    char temp = letters[left];
                    letters[left] = letters[right];
                    letters[right] = temp;
                    left++;
                    right--;
                }
            }

            return new String(letters);
        }
    }






}
