package linkedlist;

import java.util.Random;

public class GetRandom {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(head,2);
        head.addNode(head,3);

        GetRandom instance = new GetRandom(head);
        System.out.println(instance.getRandom());
        System.out.println(instance.getRandom());
        System.out.println(instance.getRandom());
        System.out.println(instance.getRandom());

    }
    int ans;
    int cnt;
    ListNode head;
    Random random = new Random();
    public GetRandom(ListNode head) {
        this.head = head;
    }
    public int getRandom() {
        cnt = 0;
        ans = 0;
        ListNode next = head;
        while(head!=null){
            if(random.nextInt(cnt+1)==0){
                ans = head.val;
            }
            head = head.next;
            cnt++;
        }
        head = next;
        return ans;
    }
}
