import java.util.Stack;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/19
 */
public class JZO24 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了6.56% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了26.67% 的用户
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode root=new ListNode(0);
        ListNode cur=head;
        root.next=head;

        while (cur != null) {
            stack.push(cur);
            ListNode temp=cur.next;
            cur.next=null;
            cur=temp;
        }
        ListNode pre=null;
        while (!stack.isEmpty()) {
            if (pre == null) {
                pre=stack.pop();
                root.next=pre;
                continue;
            }
            pre.next=stack.pop();
            pre=pre.next;
        }
        return root.next;
    }

    @Test
    public void test(){
        ListNode listNode = reverseList(ListNodeUtils.arrayToListNode(new int[] {1, 2, 3, 4, 5}));
    }
}
