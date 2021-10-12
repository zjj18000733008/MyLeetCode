import java.util.Stack;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/12
 */
public class JZO06 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了15.43% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了89.17% 的用户
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head){

        ListNode root=new ListNode(0);
        ListNode cur=head;
        root.next=head;

        Stack<ListNode> stack = new Stack<>();

        int count=0;
        while (cur != null) {
            stack.add(cur);
            ListNode next=cur.next;
            cur.next=null;
            cur=next;
            count++;
        }

        int[] ans = new int[count];
        int i=0;
        while (!stack.isEmpty()) {
            ans[i]=stack.pop().val;
            i++;
        }
        return ans;
    }

    @Test
    public void test(){
        ListNode head = ListNodeUtils.arrayToListNode(new int[] {1, 3, 2});
        for (int i : reversePrint(head)) {
            System.out.print(i+" ");
        }
    }
}
