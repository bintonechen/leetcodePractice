/**
 * Date: 2025/1/28 15:51
 * 383. Ransom Note
 */

package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LC383 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            Map <Character, Integer> magazineMap = new HashMap<>();

            for(int i = 0; i<magazine.length(); i++){
                magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i),0)+1);
            }

            for(int i = 0; i<ransomNote.length();i++){
                if(magazineMap.containsKey(ransomNote.charAt(i)) && magazineMap.get(ransomNote.charAt(i))>0){
                    magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i))-1);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean canConstruct(String ransomNote, String magazine) {

            int [] letters = new int [26];
            char [] magazineArray = magazine.toCharArray();
            char [] ransomNoteArray = ransomNote.toCharArray();

            for(char c: magazineArray){
                letters[c - 'a']++;
            }

            for(char c: ransomNoteArray){
                letters[c - 'a']--;
            }

            for(int i: letters){
                if(i<0){
                    return false;
                }
            }

            return true;
        }
    }

}
