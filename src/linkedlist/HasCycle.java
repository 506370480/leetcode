package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {

    }

    //下边使用最常用的方式，使用set来解决
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return false;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //下边使用判断环的更常用的方式，就是快慢指针的方式
    //有个疑惑，如何使用指针呢，这个是链表形式呀
    //fast slow //start mid end
    public static boolean hasCycle1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
