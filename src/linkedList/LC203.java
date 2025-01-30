/**
 * Date: 2025/1/22 12:19
 * 203. Remove Linked List Elements
 */

package linkedList;

public class LC203 {

     // Definition for singly-linked list
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution1 {
        public ListNode removeElements(ListNode head, int val) {

            // skip all nodes at the beginning that have the target value
            while(head != null && head.val == val){
                head = head.next;
            }

            // if the list is empty after removing initial nodes
            if(head == null){
                return head;
            }

            ListNode current = head;

            while(current !=null && current.next != null){
                if(current.next.val == val){
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return head;

        }
    }

    // create a dummy node as a new head
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {

            // create a dummy node to act as a new head before the actual list
           ListNode dummy = new ListNode();
           dummy.next = head;

            ListNode cur = dummy;

            while(cur.next != null){
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }
    }








}
