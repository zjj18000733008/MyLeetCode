import java.util.List;

/**
 * @author JJ
 * @date 2020/11/11 - 21:35
 */
public class No92 {

    ListNode nodeN=null;
    ListNode nodeAfterN=null;

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：36 MB, 在所有 Java 提交中击败了89.79% 的用户
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null){
            return head;
        }
        if(m==n){
            return head;
        }
        int count=m+1;
        ListNode preNode=new ListNode(0);
        ListNode curNode=head;
        preNode.next=curNode;
        while(m-1>0){
            preNode=preNode.next;
            curNode=curNode.next;
            m--;
        }
        ListNode node = func1(curNode, curNode.next, n, count);
        preNode.next=nodeN;
        node.next=nodeAfterN;
        return count==2?preNode.next:head;
    }

    public ListNode func1(ListNode preNode,ListNode curNode,int n,int count){
        if(count==n){
            nodeN=curNode;
            nodeAfterN=curNode.next;
            curNode.next=preNode;
            preNode.next=null;
            return preNode;
        }
        ListNode node = func1(preNode.next, curNode.next, n, ++count);
        node.next=preNode;
        preNode.next=null;
        return preNode;
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
        //---------------
//        ListNode n1 = new ListNode(3);
//        ListNode n2 = new ListNode(5);
//        n1.next=n2;
        No92 no = new No92();
        ListNode node = no.reverseBetween(n1, 2, 4);
//        ListNode node = no.reverseBetween(n1, 1, 2);
    }
}
