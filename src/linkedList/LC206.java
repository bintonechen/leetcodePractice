/**
 * Date: 2025/1/22 16:10
 * 206. Reverse Linked List
 */

package linkedList;

public class LC206 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
    }

    // two pointer
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null; // the previous node
            ListNode cur = head;
            ListNode temp = null; // temporary node to store the next node

            while (cur != null){
                temp = cur.next; // store the next node temporarily
                cur.next = prev; // point current node to the previous node (to reverse pointer)
                prev =cur;
                cur = temp;
            }
            return prev; // the new head of the reversed list
        }
    }

    // recursion
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            return reverse(null, head);
        }

        public ListNode reverse(ListNode prev, ListNode cur){
            if(cur == null){
                return prev;
            }
            ListNode temp = cur.next;
            cur.next = prev;
            return reverse(cur, temp);
        }
    }

    // recursive backtracking approach
    class Solution3 {
        public ListNode reverseList(ListNode head) {

            // base cases
            if(head == null) return null; // empty list
            if (head.next == null) return head; // single node, already reverse

            // recursive call
            ListNode last = reverseList(head.next);
            // point the next node's next pointer (head.next.next) back to the current node (head)
            head.next.next = head;
            // mark the current node as the tail by setting its next pointer to null
            head.next = null;
            // return the new head of the reversed list
            return last;
        }


    }


}
