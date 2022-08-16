package linkedlist;

public class RotateRight {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(node, 2);
        node.addNode(node, 4);

        System.out.println(rotateRight(node, 4));
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null){
            return head;
        }
        int n = 0;
        ListNode len = head;
        while(len!=null){
            len = len.next;
            n++;
        }
        k = k%n;
        if(k==0){
            return head;
        }
        ListNode res = head;
        while(n-k-1!=0){
            res = res.next;
            n--;
        }
        ListNode res1 = res.next;
        ListNode res2 = res.next;
        while(res1.next!=null){
            res1 = res1.next;
        }
        res.next = null;
        res1.next = head;
        return res2;

    }

    public static ListNode rotateRight1(ListNode head, int k) {
        if(head == null||head.next == null){
            return head;
        }
        int n = 0;
        ListNode len = head;
        while(len.next!=null){
            len = len.next;
            n++;
        }
        n++;
        len.next = head;
        k = k%n;
        if(k==0){
            return head;
        }
        while(n-k-1!=0){
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
