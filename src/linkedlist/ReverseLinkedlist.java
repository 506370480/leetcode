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
//        //ʹ��ջ���
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
//        //���������һ�䣬�ͻ���ֽڵ��ڲ�ѭ���������
//        //Error - Found cycle in the ListNode
//        //ԭ�����ڴ浽ջ��ߵĽڵ㶼����next�ģ�1��next��2��
//        // (�䷴ת���൱��β�ڵ㣩���������Ϊnull���ͻ��γɻ��ƣ��μ�https://chowdera.com/2021/12/202112262355492042.html
//        pre.next = null;
//        return head;


        //�±����������ÿ�η��ʵ�ԭ����ڵ㶼���Ϊ�������ͷ���
        //���Ǻ�����⣬�������Լ����������޷�������еĹؼ���Ϣ��
        while(head ==null){
            return head;
        }
        //java����Ȼû��ָ�룬�������࣬��ʹ��ListNode newHead = head��ʱ��head��newHead��ͬ���ı�ģ�ͬһ������
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
