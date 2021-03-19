/**
 * @author JJ
 * @date 2020/7/31 - 21:07
 */
public class No206 {
    //0ms
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode preHead = new ListNode(0);//自定义一个头指针
        preHead.next = head;
        ListNode node = reList(preHead, head);
        node.next = null;
        return preHead.next;
    }
    public ListNode reList(ListNode preHead, ListNode cur) {
        if (cur.next == null) {
            preHead.next = cur;
        } else {
            ListNode node = reList(preHead, cur.next);
            node.next = cur;
        }
        return cur;
    }
//--------------------------------------------------------------------------
    ListNode root=null;
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了35.02% 的用户
     * @author JJ
     * @date 2020/11/17 18:16
     */
    public ListNode reverseList_2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        func1(head, head.next);
        return root;
    }
    public ListNode func1(ListNode preNode,ListNode curNode){
        if(curNode.next==null){
            preNode.next=null;
            curNode.next=preNode;
            root=curNode;
            return preNode;
        }
        ListNode node = func1(preNode.next, curNode.next);
        node.next=preNode;
        preNode.next=null;
        return preNode;
    }
//-------------------------------------------------------------------
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
        No206 no = new No206();
        ListNode node = no.reverseList_2(n1);
    }
}
