package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {

    }

    //�±�ʹ����õķ�ʽ��ʹ��set�����
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

    //�±�ʹ���жϻ��ĸ����õķ�ʽ�����ǿ���ָ��ķ�ʽ
    //�и��ɻ����ʹ��ָ���أ������������ʽѽ
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
