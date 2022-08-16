package linkedlist;

/**
 * 已经有序
 * 删除重复元素
 * 双指针
 * 考虑数组的情况
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.addNode(node1, 1);
        node1.addNode(node1, 4);
        System.out.println(deleteDuplicates(node1));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            while(fast != null && fast.val==slow.val){
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
        }
        return head;
    }
}
