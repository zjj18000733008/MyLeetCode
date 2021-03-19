/**
 * @author JJ
 * @date 2020/8/30 - 11:59
 */
public class No86 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：39.5 MB, 在所有 Java 提交中击败了22.47% 的用户
    public ListNode partition(ListNode head, int x) {
        ListNode left=new ListNode(-1);
        ListNode right=new ListNode(-1);
        ListNode pl=left,pr=right;
        while(head!=null){
            if(head.val<x){
                pl.next=head;
                pl=pl.next;
            }else{
                pr.next=head;
                pr=pr.next;
            }
            head=head.next;
        }
        pl.next=right.next;
        pr.next=null;
        return left.next;
    }

    public static void main(String[] args) {
        No86 no = new No86();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode node = no.partition(n1, 3);
    }
}
