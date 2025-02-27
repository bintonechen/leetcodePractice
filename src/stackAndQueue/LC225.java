/**
 * Date: 2025/2/27 10:02
 * 225. Implement Stack using Queues
 */

package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class LC225 {

    // approach: with 2 queue
    class MyStack {

        Queue<Integer> queue;
        Queue<Integer> queueTemp;

        // LinkedList implements both List and Queue interfaces.
        // Use offer(), poll(), peek() when treating LinkedList as a Queue.
        // Use add(), remove(), get() when treating LinkedList as a List.

        public MyStack() {
            queue = new LinkedList<>(); // main queue acting as the stack
            queueTemp = new LinkedList<>(); // temporary queue for reordering elements
        }

        public void push(int x) {

            // push x into temporary queue
            queueTemp.offer(x);

            // move all elements from the main queue to temporary queue
            while(!queue.isEmpty()){
                int tempInt = queue.poll();
                queueTemp.offer(tempInt);
            }

            // swap the names of the two queues
            Queue<Integer> temp = queue;
            queue = queueTemp;
            queueTemp = temp;
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }


    // approach with only one queue
    class MyStack1 {

        Queue<Integer> queue;

        public MyStack1() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // enqueue the new element
            queue.offer(x);
            int size = queue.size();

            // move the previous elements to the back of the queue
            for(int i = 0; i < size-1; i++){
                int temp = queue.poll();
                queue.offer(temp);
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
