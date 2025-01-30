/**
 * Date: 2025/1/26 08:03
 * 242. Valid Anagram
 */

package hashmap;

import java.util.HashMap;

public class LC242 {

    // HashMap Counting Approach
    class Solution1 {
        public boolean isAnagram(String s, String t) {

            // check the length of the two strings
            if(s.length() !=t.length()) return false;

            // Use a HashMap to count occurrences of characters in `s`
            HashMap<Character, Integer> sMap = new HashMap<>();

            for(int i = 0; i<s.length(); i++){
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            }

            // check if every letter in t exists in the HashMap, is it does, value -1
            for(int i = 0; i<t.length(); i++){
                if(sMap.containsKey(t.charAt(i))){
                    sMap.put(t.charAt(i), sMap.get(t.charAt(i))-1);
                } else {
                    return false;
                }
            }

            for(int val: sMap.values()){
                if(val !=0) return false;
            }

            return true;
        }
    }


    // Array Counting Method
    class Solution2 {
        public boolean isAnagram(String s, String t) {

            // a size 26 array to count occurrences of each character
            int [] record  = new int[26];

            // increment counts for characters in string 's'
            for(int i = 0; i<s.length(); i++){
                record[s.charAt(i)-'a']++;
            }

            // decrement counts for characters in string 't'
            for(int i = 0; i<t.length(); i++){
                record[t.charAt(i)-'a']--;
            }

            for(int count: record){
                if(count !=0){
                    return false;
                }
            }

            return true;
        }
    }

}
