/**
 * @author JJ
 * @date 2020/8/4 - 14:15
 */
public class No237 {

    public void deleteNode(ListNode node) {
        ListNode pre=null;
        while(node.next!=null){
            node.val=node.next.val;
            pre=node;
            node=node.next;
        }
        pre.next=null;
    }
}
