package linkedlist;

public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(node,2);
        node.addNode(node,4);

        ListNode node1 = new ListNode(1);
        node1.addNode(node1,3);
        node1.addNode(node1,4);


        ListNode listNode = mergeTwoLists(node, node1);
        System.out.println(listNode);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode nodes = new ListNode();
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }
        //学习这里链表增加节点的思路
        //1.头节点=temp 2.temp.next = 要相加的值 3.temp = temp.next
        ListNode tmp = nodes;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                tmp.next = list2;
                tmp  = tmp.next;
                list2 = list2.next;
            }else{
                tmp.next = list1;
                tmp  = tmp.next;
                list1 = list1.next;
            }
        }
        if(list1==null){
            tmp.next=list2;
        }else {
            tmp.next = list1;
        }
        return nodes.next;
    }
}
