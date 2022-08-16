package linkedlist;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedlist {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.addNode(node,2);
        node.addNode(node,3);
        node.addNode(node,4);
        node.addNode(node,5);
        System.out.println(node);

        ListNode listNode = reverseList(head);
        System.out.println(listNode);

    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode reverseList(ListNode head) {
//        //使用栈解决
//        Stack<ListNode> stack = new Stack();
//        while (head.next != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode pre = head;
//        while (!stack.empty()) {
//            pre.next = stack.pop();
//            pre = pre.next;
//        }
//        //如果不加这一句，就会出现节点内部循环的情况，
//        //Error - Found cycle in the ListNode
//        //原因在于存到栈里边的节点都是有next的，1的next是2，
//        // (其反转后相当于尾节点）如果不设置为null，就会形成环绕，参见https://chowdera.com/2021/12/202112262355492042.html
//        pre.next = null;
//        return head;


        //下边这个方法，每次访问的原链表节点都会成为新链表的头结点
        //但是很难理解，至少是自己觉得现在无法理解其中的关键信息。
        while(head ==null){
            return head;
        }
        //java中虽然没有指针，但是有类，当使用ListNode newHead = head的时候，head和newHead是同步改变的（同一个对象）
        ListNode newHead = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

}
