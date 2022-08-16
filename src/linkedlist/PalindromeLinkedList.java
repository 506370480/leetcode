package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(node,2);
        node.addNode(node,3);
        node.addNode(node,4);
        node.addNode(node,5);
        System.out.println(node);

        boolean palindrome = isPalindrome(node);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(head==null){
            return true;
        }
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0,j=list.size()-1; i < list.size()/2; i++,j--) {
            if(list.get(i)!=list.get(j)){
                return false;
            }

        }
        return true;
    }
}
