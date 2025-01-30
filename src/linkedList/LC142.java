/**
 * Date: 2025/1/24 10:48
 * 142. Linked List Cycle II
 */

package linkedList;

import java.util.HashSet;
import java.util.Set;

public class LC142 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // hash set approach
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            Set <ListNode> visited = new HashSet<>();
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            while(dummy.next != null && !visited.contains(dummy.next)){
                visited.add(dummy.next);
                dummy = dummy.next;
            }

            while(dummy.next == null){
                return null;
            }

            return dummy.next;

        }
    }

    // two pointer approach
    public class Solution2 {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast !=null && fast.next!=null){
                slow = slow.next; // slow pointer moves 1 step
                fast=fast.next.next; // fast pointer moves 2 steps

                if(fast == slow){ // cycle detected when fast and slow pointers meet
                    // to find the start of the cycle
                    ListNode temp1 = head; // start from the head
                    ListNode temp2 = fast; // start from the meeting point

                    while(temp1 != temp2){ // loop until temp1 amd temp2 meet
                        temp1 = temp1.next;
                        temp2 = temp2.next;
                    }

                    return temp1; // the node where they meet is the start of the cycle

                }
            }

            return null;
        }
    }




}
