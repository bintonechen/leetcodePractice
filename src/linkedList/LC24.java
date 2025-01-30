/**
 * Date: 2025/1/23 09:13
 * LeetCode 24. Swap Nodes in Pairs
 */

package linkedList;

public class LC24 {
     public class ListNode {
         int val;
         ListNode next;

         ListNode() {
         }

         ListNode(int val) {
             this.val = val;
         }

         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }


    class Solution {
        public ListNode swapPairs(ListNode head) {

            // edge cases
            if(head== null || head.next == null){
                return head;
            }

            // create a dummy node for swapping the first pair
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.next != null){
                // nodes to swap
                ListNode first = prev.next;
                ListNode second = prev.next.next;

                // swap the nodes
                first.next = second.next;
                second.next = first;
                prev.next = second;

                prev = first;
            }

            // return the new head of the list (the second node of the original list)
            return dummy.next;
        }
    }



}
