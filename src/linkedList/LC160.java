/**
 * Date: 2025/1/23 21:04
 * 160. Intersection of Two Linked Lists
 */

package linkedList;

import java.util.HashSet;
import java.util.Set;

public class LC160 {

      public class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
              next = null;
          }
      }

      // Hashset approach
      public class Solution1 {
          public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
              Set<ListNode> visited = new HashSet<ListNode>();
              ListNode temp = headA;
              while(temp!=null){
                  visited.add(temp);
                  temp = temp.next;
              }
              temp = headB;
              while(temp!=null){
                  if(visited.contains(temp)){
                      return temp;
                  }
                  temp = temp.next;
              }
              return null;
          }
      }

      // two pointer approach
      public class Solution2 {
          public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

              if(headA == null || headB == null) return null;

              ListNode a = headA;
              ListNode b = headB;

              while(a!=b){
                  a = a==null? headB : a.next;
                  b = b==null? headA : b.next;
              }
              return a;
          }
      }





}
