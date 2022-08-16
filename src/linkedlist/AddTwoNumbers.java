package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(node, 2);
        node.addNode(node, 4);

        ListNode node1 = new ListNode(1);
        node1.addNode(node1, 3);
        node1.addNode(node1, 4);
        System.out.println(addTwoNumbers(node, node1));
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        ListNode node = new ListNode();
        ListNode res = node;
        int add = 0,i=0,j=0;
        while (i<list1.size()||j<list2.size()||add!=0){
            int x = i<list1.size()?list1.get(i):0;
            int y = j<list2.size()?list2.get(j):0;
            int result = (x+y+add)%10;
            add = (x+y+add)/10;
            i++;
            j++;
            node.setVal(result);
            if(i<list1.size()||j<list2.size()||add!=0) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        return res;
/*       //使用这种方法的话会导致parseInt发生越界异常，但是list可以是无限长的
        //可以转化为大数相加
        int nums = Integer.parseInt(s1)+Integer.parseInt(s2);
        ListNode node = new ListNode(nums%10);
        ListNode res = node;
        nums = nums/10;
        while (nums!=0){
            node.next = new ListNode(nums%10);
            nums = nums/10;
            node = node.next;
        }
        return res;*/
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode node = new ListNode();
        ListNode res = node;
        int add = 0;
        while(l1!=null||l2!=null||add!=0){
            int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;
            int result = x+y+add;
            node.val = (x+y+add)%10;
            add = (x+y+add)/10;
            if(l1!=null) {
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
            if(l1!=null||l2!=null||add!=0){
                node.next = new ListNode();
                node = node.next;
            }
        }
        return res;
    }
}
