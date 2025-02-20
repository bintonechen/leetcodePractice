/**
 * Date: 2025/2/19 14:32
 * 28. Find the Index of the First Occurrence in a String
 * KMP Visually Explained (YouTube): https://www.youtube.com/watch?v=ynv7bbcSLKE
 */

package String;

public class LC28 {

    // KMP approach: prefix-suffix table
    class Solution {
        public int strStr(String haystack, String needle) {

            int n = needle.length();
            if(n ==0){
                return 0;
            }

            // create and build the prefix table
            int[] next = new int[n];
            getNext(next,needle);

            int j = 0;
            for(int i = 0; i< haystack.length(); i++){
                // if there's a mismatch, move j back to the longest previous matching prefix
                while(j>0 && needle.charAt(j)!=haystack.charAt(i)){
                    j = next[j-1];
                }

                if(needle.charAt(j) == haystack.charAt(i)){
                    j++;
                }

                if(j==needle.length()){
                    return i-n+1;
                }
            }

            return -1;
        }

        public void getNext(int[] next, String s){
            int j = 0; // to track the length of the proper prefix/suffix
            next[0] = 0;

            for(int i = 1; i<s.length();i++){ // build from the second character
                // if a mismatch, move j back to the previous prefix position
                while(j>0 && s.charAt(j)!=s.charAt(i)){
                    j = next[j-1];
                }
                // if characters match, increase j
                if(s.charAt(j)==s.charAt(i)){
                    j++;
                }

                next[i] = j; // store the length of the prefix for the current position
            }
        }

    }

}
