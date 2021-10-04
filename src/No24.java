/**
 * @author JJ
 * @date 2020/8/19 - 16:43
 */
public class No24 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：37.1 MB, 在所有 Java 提交中击败了91.29% 的用户
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        ListNode root = new ListNode(0);//给head加个头指针
        root.next=head;
        ListNode pre=root;
        ListNode p1=head;
        ListNode p2=head.next;
        if(p2==null) {
            return head;
        }
        while(true){
            //交换
            p1.next=p2.next;
            p2.next=p1;
            pre.next=p2;

            pre=p1;
            //如果链表只剩一个或不剩则结束循环
            if(p1.next==null) {
                break;
            } else if(p1.next.next==null) {
                break;
            } else {
                //否则p1,p2向后移
                p2=p1.next.next;
                p1=p1.next;

            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        No24 no = new No24();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
        no.swapPairs(n1 );
    }
}
