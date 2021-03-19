/**
 * @author JJ
 * @date 2020/8/6 - 20:17
 */
public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode pre=root;
        int carry=0;

        while(l1!=null || l2!=null || carry!=0){

            int l1val=l1==null?0:l1.val;
            int l2val=l2==null?0:l2.val;
            int sum=l1val+l2val+carry;
            carry=sum/10;
            pre.next=new ListNode(sum%10);
            pre=pre.next;

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }

        return root.next;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(4);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(5);
//        ListNode n5 = new ListNode(6);
//        ListNode n6 = new ListNode(6);
//        n1.next=n2;
//        n2.next=n3;
//        n4.next=n5;
//        n5.next=n6;
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(5);
        No2 no = new No2();
        ListNode node = no.addTwoNumbers(n1, n2);
    }
}
