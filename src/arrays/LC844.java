/**
 * Date: 2024/12/25 09:51
 * 844. Backspace String Compare
 */

package arrays;

import java.util.Stack;

public class LC844 {

    // solution 1: reverse iteration with two pointers
    public boolean backspaceCompare(String s, String t) {

        int s_index = s.length() - 1;
        int t_index = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (s_index >=0 || t_index >=0){

            // find the next valid char in s
            while(s_index>=0){
                if(s.charAt(s_index) == '#'){
                    s_index--;
                    skipS++;
                } else if (skipS>0){
                    s_index--;
                    skipS--;
                } else break;
            }

            // find the next valid char in t
            while(t_index>=0){
                if(t.charAt(t_index)=='#'){
                    t_index--;
                    skipT++;
                } else if (skipT>0){
                    t_index--;
                    skipT--;
                } else break;
            }

            // check if two valid characters are different
            if(s_index >= 0 && t_index >=0 && s.charAt(s_index) !=t.charAt(t_index)){
                return false;
            }

            // compare these two boolean values
            // to check if one string has remaining characters while the other does not
            if((s_index>=0) != (t_index>=0)){
                return false;
            }
        }
        return true;
    }

    // solution 2: build string with stack
    public boolean backspaceCompare2(String s, String t) {
        String newS = buildString(s);
        String newT = buildString(t);

        return newS.equals(newT);
    }

    public String buildString(String str){
        Stack<Character> strStack = new Stack<> ();

        for (char c: str.toCharArray()){
            if(c != '#'){
                strStack.push(c);
            } else if (!strStack.empty()){
                strStack.pop();
            }
        }

        StringBuilder finalStr = new StringBuilder();
        for (char c : strStack){
            finalStr.append(c);
        }

        return finalStr.toString();
    }

}
