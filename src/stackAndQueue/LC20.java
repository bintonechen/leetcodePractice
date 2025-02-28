/**
 * Date: 2025/2/28 07:59
 * 20. Valid Parentheses
 */

package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC20 {

    class Solution {
        public boolean isValid(String s) {

            // Deque supports stack-like (LIFO) operations (push(), pop(), peek())
            // and queue-like (FIFO) operations (offer(), poll(), peek()).
            Deque<Character> pareStack = new LinkedList<>();

            // Why not use the following line?
            // Stack<Character> pareStack = new Stack<>();
            // - Stack<E> extends Vector<E>, which is synchronized and incurs unnecessary performance overhead.
            // - Deque (e.g., LinkedList or ArrayDeque) is the recommended alternative for stack operations in Java.

            char[] charList = s.toCharArray();
            int num = charList.length-1;

            for(int i = 0; i<=num; i++){
                if(charList[i]=='(' || charList[i]=='{' || charList[i]=='[' ){
                    pareStack.push(charList[i]);
                } else if(charList[i]==')'){
                    if(pareStack.isEmpty() || pareStack.peek()!='(') return false;
                    pareStack.pop();
                } else if(charList[i]=='}'){
                    if(pareStack.isEmpty() || pareStack.peek()!='{') return false;
                    pareStack.pop();
                } else if(charList[i]==']'){
                    if(pareStack.isEmpty() || pareStack.peek()!='[') return false;
                    pareStack.pop();
                }
            }

            if (pareStack.isEmpty()){
                return true;
            } else {
                return false;
            }
        }
    }

}
