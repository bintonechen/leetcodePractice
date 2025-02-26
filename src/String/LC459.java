/**
 * Author: Bintong
 * Date: 2025/2/26 09:00
 */

package String;

public class LC459 {

    // approach with String built-in methods: substring() and repeat()
    // O(n²) time
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for(int i = 1; i<=n/2; i++){
            if(n%i==0 && s.substring(0,i).repeat(n/i).equals(s)){
                return true;
            }
        }
        return false;
    }

    // approach with String Concatenation
    // O(n) time
    public boolean repeatedSubstringPattern1(String s) {

        // Concatenating the string with itself (`s + s`).
        String concatenated = s + s;

        // Removing the first and last characters of the concatenated string to eliminate the original string
        String sub = concatenated.substring(1, concatenated.length()-1);

        // checking if the original string `s` is a substring of the modified concatenated string.
        return concatenated.contains(sub);

    }

    // approach with KMP
    // O(n) time
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        int[] next = new int[n];
        getNext(next, s);

        int len = next[n-1]; // length of the longest equal prefix and suffix
        return len != 0 && n % (n - len) == 0;
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
