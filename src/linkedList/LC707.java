/**
 * Date: 2025/1/22 14:36
 * 707. Design Linked List
 */

package linkedList;

public class LC707 {


    class MyLinkedList {

        class ListNode{
            int val;
            ListNode next;

            ListNode(){}
            ListNode(int val){
                this.val = val;
            }
            ListNode(int val, ListNode next){
                this.val = val;
                this.next = next;
            }
        }

        private ListNode head;
        private ListNode last;
        private int size;


        public MyLinkedList() {
            size = 0;
            head = null;
            last = null;
        }

        public int get(int index) {
            if(index<0 || index >= size){
                return -1;
            }
            ListNode current = head;
            for (int i = 0; i <index; i++){
                current = current.next;
            }
            return current.val;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;

            // If the list was empty, update the tail
            if (size == 0) {
                last = head;
            }
            size++;
        }

        public void addAtTail(int val) {
            ListNode newLast = new ListNode(val);

            if(size == 0){
                head = newLast;
                last = newLast;
            } else {
                last.next = newLast;
                last = newLast;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {

            if(index<0 || index > size){
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }

            ListNode newNode = new ListNode(val);
            ListNode cur = head;

            for (int i = 0; i<index-1; i++){
                cur= cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }



        public void deleteAtIndex(int index) {

            if(index<0 || index >= size){
                return;
            } else if (size == 1) {
                head = null;
                last = null;
            } else if (index == 0){
                head = head.next;
            } else if(index == size-1){
                // remove the last node
                ListNode temp = head;
                for (int i = 0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = null;
                last = temp;
            } else {
                // remove a node in the middle
                ListNode temp = head;
                for (int i = 0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            size --;

        }
    }

}
