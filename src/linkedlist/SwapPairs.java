package linkedlist;


//先放弃，各种指针关系搞不清楚
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(head,2);
        head.addNode(head,3);

        System.out.println(swapPairs(head));
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode res = head;
        ListNode tmp = new ListNode();
        while(head.next != null){
            tmp = head;
            tmp.next = null;
            head = head.next;
            head.next = tmp;
            if(head.next.next == null||head.next.next.next==null) break;
            head = head.next.next;
        }
        return res;
    }
}
