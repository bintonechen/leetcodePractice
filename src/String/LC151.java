/**
 * Date: 2025/2/9 07:57
 * 151. Reverse Words in a String
 */

package String;

public class LC151 {

    // two-pointer approach with StringBuilder
    class Solution {
        public String reverseWords(String s) {

            StringBuilder sb = new StringBuilder();

            int right = s.length()-1;

            while(right>=0){
                // skip spaces
                while(right>=0 && s.charAt(right)==' '){
                    right--;
                }
                if(right<0){
                    break;
                }

                // find the start of current word
                int left = right;
                while(left-1>=0 && s.charAt(left-1)!=' '){
                    left--;
                }
                if(left<=right){
                    sb.append(s.substring(left, right+1));
                    sb.append(' ');
                }

                // update right pointer
                right = left-1;
            }

            if(sb.isEmpty()){
                return sb.toString();
            } else {
                // remove the last extra space
                return sb.deleteCharAt(sb.length()-1).toString();
            }

        }
    }


    // regular expression approach
    public class Solution2 {
        public String reverseWords(String s) {
            // Trim spaces and reduce multiple spaces to single spaces
            String[] words = s.trim().split("\\s+");

            // Reverse the entire array of words
            StringBuilder sb = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]);
                if (i > 0) {
                    sb.append(' ');
                }
            }

            return sb.toString();
        }
    }




}
