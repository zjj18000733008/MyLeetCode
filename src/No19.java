/**
 * @author JJ
 * @date 2020/8/17 - 14:53
 */
public class No19 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：38 MB, 在所有 Java 提交中击败了36.34% 的用户
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root=new ListNode(0);
        root.next=head;
        int height = height(root);//将删除正序下标为height-n的结点
        deleteNode(root,height-n,-1);
        return root.next;
    }
    private int height(ListNode root){

        ListNode node=root;
        int height=0;
        while(node.next!=null){

            height++;

            node=node.next;
        }
        return height;
    }
    private void deleteNode(ListNode parent,int n,int count){
        count++;
        if(n==count){
            parent.next=parent.next.next;
        }else{
            deleteNode(parent.next,n,count);
        }
    }

    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：37.9 MB, 在所有 Java 提交中击败了58.91% 的用户
    public ListNode removeNthFromEnd_2(ListNode head,int n){
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode fast=root,slow=root;
        while(n-->0){//快指针先走
            fast=fast.next;
        }
        while(fast.next!=null){//快慢指针一起走
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return root.next;
    }

    /**
     * 复习重做
     * @author JJ
     * @date 2020/11/16 21:57
     */
    public ListNode removeNthFromEnd_3(ListNode head,int n){
        ListNode beforeHead=new ListNode(0);
        ListNode fast=beforeHead;
        ListNode slow=beforeHead;
        beforeHead.next=head;
        while(n-->0){
            fast=fast.next;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return beforeHead.next;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        No19 no = new No19();
        no.removeNthFromEnd_3(n1,2);
    }

    public ListNode removeNthFromEnd_4(ListNode head,int n){

        ListNode root = new ListNode(0);
        root.next=head;
        ListNode fast=root;
        ListNode slow=root;

        while(n-->0){
            fast=fast.next;
        }

        while (fast.next != null) {
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;

        return root.next;
    }
}
