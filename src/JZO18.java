import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/18
 */
public class JZO18 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了7.41% 的用户
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next=head;
        ListNode pre=root;
        ListNode cur=head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next=cur.next;
            }
            pre=pre.next;
            cur=cur.next;
        }
        return root.next;
    }

    @Test
    public void test(){
        deleteNode(ListNodeUtils.arrayToListNode(new int[]{4,5,1,9}), 5);
    }
}
