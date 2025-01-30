/**
 * Date: 2025/1/23 10:32
 * 19. Remove Nth Node From End of List
 */

package linkedList;

public class LC19 {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;

            for (int i = 0; i<n; i++){
                fast = fast.next;
            }

            while(fast.next !=null){
                fast = fast.next;
                slow = slow.next;
            }

                slow.next = slow.next.next;

            return dummy.next;
        }
    }








}
