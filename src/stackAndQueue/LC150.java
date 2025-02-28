/**
 * Date: 2025/2/28 09:16
 * 150. Evaluate Reverse Polish Notation
 */

package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC150 {
    class Solution {
        public int evalRPN(String[] tokens) {

            Deque<Integer> stack = new ArrayDeque<>(); // to hold integers during evaluation

            for(String s: tokens){
                if(s.equals("+")){
                    stack.push(stack.pop()+stack.pop());
                } else if (s.equals("-")){
                    stack.push(-stack.pop()+stack.pop());
                } else if(s.equals("*")){
                    stack.push(stack.pop()*stack.pop());
                } else if(s.equals("/")){
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2/temp1);
                } else {
                    // if the token is an operand, push it onto the stack as an integer
                    stack.push(Integer.valueOf(s));
                }
            }

            return stack.pop();

        }
    }
}
