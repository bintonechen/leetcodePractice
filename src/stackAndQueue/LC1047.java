/**
 * Date: 2025/2/28 08:30
 * 1047. Remove All Adjacent Duplicates In String
 */

package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LC1047 {

    class Solution {
        public String removeDuplicates(String s) {

            int lastIndex = s.length()-1;

            // Deque is an interface that is commonly implemented by concrete classes like LinkedList or ArrayDeque.
            // Why use Deque<Character> instead of a specific implementation like ArrayDeque<Character>?
            // - By programming to the 'Deque' interface rather than a concrete implementation like 'ArrayDeque',
            //   you gain flexibility. This allows you to easily switch to any other implementation of Deque (e.g., LinkedList)
            //   without modifying the rest of the code that interacts with the 'charList' variable.
            // - This practice promotes loose coupling and enhances maintainability, as you are not tied to a specific implementation.

            Deque<Character> charList = new ArrayDeque<>(); // faster for most queue/stack operations
            //  Deque<Character> charList = new LinkedList<>(); // Slower for random access but fast for insertions/removals

            for(int i =0; i<=lastIndex; i++){
                if(charList.isEmpty()) {
                    charList.push(s.charAt(i));
                } else if (charList.peek()==s.charAt(i)){
                    charList.pop();
                } else {
                    charList.push(s.charAt(i));
                }
            }

            // Build result in correct order by reversing the stack
            StringBuilder sb = new StringBuilder();
            while(!charList.isEmpty()){
                sb.append(charList.pollLast());
            }
            String answer = sb.toString();
            return answer;
        }
    }

}
