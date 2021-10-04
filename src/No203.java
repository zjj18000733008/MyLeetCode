import java.util.List;

/**
 * @author JJ
 * @date 2020/7/31 - 16:47
 */
public class No203 {
    public ListNode removeElements(ListNode head, int val) {
//        if(head==null || head.val==val) return null;
        if(head==null)return null;
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode pre=h;
        ListNode p=head;
        while(p!=null){
            if(p.val==val){
                pre.next=p.next;
                p=p.next;
            }else{
                pre=p;
                p=p.next;
            }

        }
        return h.next;
    }

    public static void main(String[] args) {
        No203 no = new No203();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(1);
//        n1.next=n2;
        ListNode listNode = no.removeElements(n1, 1);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.65% 的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了18.58% 的用户
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val){

        ListNode root = new ListNode(0);
        root.next=head;
        ListNode pre=root;
        ListNode curr=head;

        while (curr != null) {
            if (curr.val == val) {
                pre.next=curr.next;
            }else{
                pre=pre.next;
            }
            curr=curr.next;
        }

        return root.next;
    }
}
