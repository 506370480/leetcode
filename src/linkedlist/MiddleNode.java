package linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
�����м�ڵ㣬�ǲ��Ǳ���Ҫ����һ�����
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

        //�Ż�1�������������е�Ҳ��node��ֱ�ӷ��ؼ���
        return list.get(list.size()/2);

        //�Ż�2�����пռ��Ż���ʡȥ���� A����������һ���ϴ�����飬����ʹ���б�
        //��һ�α���ʱ������ͳ�������е�Ԫ�ظ��� N��
        //�ڶ��α���ʱ�����Ǳ������� N/2 ��Ԫ�أ�������׽ڵ�Ϊ�� 0 ��Ԫ�أ�ʱ������Ԫ�ط��ؼ��ɡ�
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
