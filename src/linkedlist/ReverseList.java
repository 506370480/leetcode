package linkedlist;

import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.addNode(node,2);
        node.addNode(node,3);
        node.addNode(node,4);
        node.addNode(node,5);
        //System.out.println(node);

        System.out.println(reverseList(node));
    }
    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode res = null;
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        if(!stack.isEmpty()){
            head = stack.pop();
            res = head;
        }
        while(!stack.isEmpty()){
            head.next = stack.pop();
            head = head.next;
            head.next = null;
        }
        return res;
    }
}
