/*
package linkedlist;

public class SortList {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        ListNode node = head;
        while(head.next!=null) {
            if (node.next.val < head.val){
                node.next.next = node;
                node = node.next;
            }
            head = head.next;
        }
    }
}
*/
