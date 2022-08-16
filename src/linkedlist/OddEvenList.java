package linkedlist;

public class OddEvenList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(node, 2);
        node.addNode(node, 3);
        node.addNode(node, 4);
        node.addNode(node, 5);

        System.out.println(oddEvenList(node));
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null||head.next == null||head.next.next==null){
            return head;
        }
        ListNode res = head;
        ListNode res1 = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while(odd!=null&&odd.next!=null&&even!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd = odd.next;
            even = even.next;
        }
        if(odd!=null) odd.next = null;
        if(even!=null) even.next=null;
        odd.next = res1;
        return res;

    }
}
