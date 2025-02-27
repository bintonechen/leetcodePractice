/**
 * Date: 2025/2/27 09:16
 * 232. Implement Queue using Stacks
 */

package stackAndQueue;

import java.util.Stack;

public class LC232 {

    class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;


        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();

        }

        public void push(int x) {
            stackIn.push(x);

        }

        public int pop() {
            dumpStackIn();
            return stackOut.pop();
        }

        public int peek() {
            dumpStackIn();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() &&stackOut.isEmpty();

        }

        public void dumpStackIn(){
            if(!stackOut.isEmpty()) return;
            while(!stackIn.isEmpty()){
                int temp = stackIn.pop();
                stackOut.push(temp);
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
