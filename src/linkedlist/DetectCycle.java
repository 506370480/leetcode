package linkedlist;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(node, 2);
        node.addNode(node, 4);
        node.next.next.setNext(node);
        System.out.println(detectCycle(node));
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast = head,slow = head;
        if(fast.next==null){
            return null;
        }
        fast = fast.next.next;
        slow = slow.next;
        while (fast!=null&&slow!=null&&fast!=slow){
            if(fast.next==null||slow.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast==null||slow==null){
            return null;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
