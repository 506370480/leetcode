package linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
返回中间节点，是不是必须要遍历一遍才行
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.addNode(node1, 3);
        //node1.addNode(node1, 4);
        System.out.println(middleNode1(node1));
    }
    public static ListNode middleNode(ListNode head) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while(node!=null){
            list.add(node);
            node = node.next;
        }
/*        for (int i = 0; i < list.size()/2; i++) {
            head = head.next;
        }
        return head;*/

        //优化1，保存在数组中的也是node，直接返回即可
        return list.get(list.size()/2);

        //优化2，进行空间优化，省去数组 A（可以设置一个较大的数组，而不使用列表）
        //第一次遍历时，我们统计链表中的元素个数 N；
        //第二次遍历时，我们遍历到第 N/2 个元素（链表的首节点为第 0 个元素）时，将该元素返回即可。
    }
    public static ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
